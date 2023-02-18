package app.studyjko.controller;

import app.studyjko.ParamKey;
import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.cd.CdService;
import app.studyjko.model.CdEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("home-page.fxml")
@RequiredArgsConstructor
public class HomePageController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button Details;


    private final ApplicationContext context;

    private final CdService cdService;


    @FXML
    private ListView<CdEntity> myListView;

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
        Details.setVisible(false);
        minimizeButton.setOnMouseClicked(mouseEvent -> {
            Stage obj = (Stage) minimizeButton.getScene().getWindow();
            obj.setIconified(true);
        });

        List<CdEntity> cdDtoList = cdService.findCdsByUserId(UserSession.getInstance().getUserDto().getId());

        myListView.getItems().addAll(cdDtoList);

        myListView.getSelectionModel().selectedItemProperty().addListener((observableValue, cdEntity, t1) -> {
            CdEntity currentCd = myListView.getSelectionModel().getSelectedItem();
            Details.setVisible(true);
            UserSession.getInstance().getParameters().put(ParamKey.CD_ID_TO_DISPLAY, String.valueOf(currentCd.getId()));
        });

    }

    public void addArticle(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        UserSession.getInstance().getParameters().remove(ParamKey.CD_ID_TO_DISPLAY);
        context.publishEvent(new StageReadyEvent(stage, NewAlbumController.class));
    }

    public void seeArticle(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        context.publishEvent(new StageReadyEvent(stage, NewAlbumController.class));
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

    public void rulesRedirect(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        context.publishEvent(new StageReadyEvent(stage, RulesController.class));
    }

}