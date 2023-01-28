package app.studyjko.controller;

import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.cd.CdDto;
import app.studyjko.data.cd.CdService;
import app.studyjko.data.user.UserDto;
import app.studyjko.data.user.UserService;
import ch.qos.logback.core.joran.event.BodyEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ResourceBundle;



@Component
@FxmlView("NewAlbumPage.fxml")
public class NewAlbumController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;


    @FXML
    private TextField creatorField;
    @FXML
    private TextField albumField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField linkField;

    @FXML
    private Label greetingLabel;

    @Autowired
    private ApplicationContext context;

    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {    //dodać obsługę wykonawcy

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

    }


    public void Add(ActionEvent event) {//AddButton





    }




}