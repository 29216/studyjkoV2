package app.studyjko.controller;

import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.cd.CdDto;
import app.studyjko.data.cd.CdService;
import app.studyjko.model.CdEntity;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

@Component
@FxmlView("home-page.fxml")
public class HomePageController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @Autowired
    private ApplicationContext context;
    @Autowired
    private CdService cdService;

    private List<CdEntity> cdDtoList;

    private String currentTitle;

    private final FxWeaver fxWeaver;

    @FXML
    private ListView<CdEntity> myListView;

    private CdEntity currentCd;

    @Autowired
    public HomePageController(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        closeButton.setOnMouseClicked(mouseEvent -> {
            boolean result = DisplayAlert.displayAlert(AlertTypeEnum.CONFIRM.getAlertType(),
                    "Exit Application",
                    "You are about to exit application",
                    "Are you sure?");
            if (result) {
                System.exit(0);
            }
        });

        minimizeButton.setOnMouseClicked(mouseEvent -> {
            Stage obj = (Stage) minimizeButton.getScene().getWindow();
            obj.setIconified(true);
        });

        cdDtoList = cdService.findCdsByUserId(UserSession.getInstance().getUserDto().getId());

//        myListView.getItems().addAll(cdDtoList.stream().map(CdDto::getTitle).toList());
        myListView.getItems().addAll(cdDtoList);

        myListView.getSelectionModel().selectedItemProperty().addListener((observableValue, cdEntity, t1) -> {
            currentCd = myListView.getSelectionModel().getSelectedItem();
            System.out.println(currentCd.getId());
        });

    }


    public void LogOut(ActionEvent event) {
        try {
            UserSession.getInstance().cleanUserSession();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            context.publishEvent(new StageReadyEvent(stage, LoginRegistrationController.class));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}