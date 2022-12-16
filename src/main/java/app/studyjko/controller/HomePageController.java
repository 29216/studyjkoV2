package app.studyjko.controller;

import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.user.UserDto;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("home-page.fxml")
public class HomePageController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Label greetingLabel;

    @Autowired
    private ApplicationContext context;
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
        displayGreetings();
    }


    public void LogOut(ActionEvent event) {
        try{
            UserSession.getInstance().cleanUserSession();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            context.publishEvent(new StageReadyEvent(stage, LoginRegistrationController.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    public void displayGreetings() {
        UserDto userDto = UserSession.getInstance().getUserDto();
        greetingLabel.setText("Witaj użytkowniku: " + userDto.getName());
    }

}