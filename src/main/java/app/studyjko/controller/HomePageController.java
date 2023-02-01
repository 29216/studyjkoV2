package app.studyjko.controller;

import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.model.CdEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxContextLoader;
import net.rgielen.fxweaver.core.FxControllerAndView;
import net.rgielen.fxweaver.core.FxWeaver;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@Component
@FxmlView("home-page.fxml")
public class HomePageController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @Autowired
    private ApplicationContext context;

    private List<CdEntity> cdEntityList;

    private final FxWeaver fxWeaver;

    @FXML
    private GridPane gridPane;

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

        cdEntityList = new ArrayList<>(
                getCdEntityList()
        );
        int column = 0;
        int row = 1;

        // still now working (?)

//        for(CdEntity cdEntity : cdEntityList){
//            FxControllerAndView<CDBoxController, AnchorPane> cdBox = fxWeaver.load(CDBoxController.class);
//            CDBoxController cdController = cdBox.getController();
//            cdController.setCD(cdEntity);
//
//            if(column == 3){
//                column = 0;
//                ++row;
//            }
//
//            gridPane.add((Node) cdBox, column++, row);
//        }

    }

    private List<CdEntity> getCdEntityList(){
        List<CdEntity> cdEntities = new ArrayList<>();

        CdEntity cdEntity = new CdEntity();
        cdEntity.setTitle("Lorem Dolor");
        cdEntity.setCreatorId(2);
        cdEntities.add(cdEntity);

        cdEntity = new CdEntity();
        cdEntity.setTitle("Lorem Dolor");
        cdEntity.setCreatorId(4);
        cdEntities.add(cdEntity);

        cdEntity = new CdEntity();
        cdEntity.setTitle("Lorem Dolor");
        cdEntity.setCreatorId(1);
        cdEntities.add(cdEntity);

        cdEntity = new CdEntity();
        cdEntity.setTitle("Lorem Dolor");
        cdEntity.setCreatorId(10);
        cdEntities.add(cdEntity);

        cdEntity = new CdEntity();
        cdEntity.setTitle("Lorem Dolor");
        cdEntity.setCreatorId(5);
        cdEntities.add(cdEntity);

        return cdEntities;
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