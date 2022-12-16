package app.studyjko.controller;

import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.user.UserDto;
import app.studyjko.data.user.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

@Component
@FxmlView("LoginRegistrationPage.fxml")
public class LoginRegistrationController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private VBox registrationVBox;

    @FXML
    private VBox loginVBox;

    @FXML
    private Button registrationOnLogin;

    @FXML
    private Button loginOnRegistration;

    @FXML
    private TextField loginField;

    @FXML
    private TextField passField;

    @FXML
    private TextField emailFieldRegister;

    @FXML
    private TextField nameFieldRegister;

    @FXML
    private TextField surnameFieldRegister;

    @FXML
    private TextField positionFieldRegister;

    @FXML
    private TextField passwordFieldRegister;

    @FXML
    private TextField repeatPasswordFieldRegister;

    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationContext context;
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {

        registrationVBox.setVisible(false);

        closeButton.setOnMouseClicked(mouseEvent -> {
            boolean result = DisplayAlert.displayAlert(AlertTypeEnum.CONFIRM.getAlertType(),
                    "Exit Application",
                    "You are about to exit application",
                    "Are you sure?");
            if (result) {
                System.exit(0);
            }
        });

        registrationOnLogin.setOnMouseClicked(mouseEvent -> {
            registrationVBox.setVisible(true);
            loginVBox.setVisible(false);
        });

        loginOnRegistration.setOnMouseClicked(mouseEvent -> {

            registrationVBox.setVisible(false);
            loginVBox.setVisible(true);
        });

        minimizeButton.setOnMouseClicked(mouseEvent -> {
            Stage obj = (Stage) minimizeButton.getScene().getWindow();
            obj.setIconified(true);
        });
    }

    public void LogIn(ActionEvent event) throws IOException {
        try{
            String login = loginField.getText();
            String pass = passField.getText();

            if(login.isBlank() && pass.isBlank()){
                boolean result = DisplayAlert.displayAlert(AlertTypeEnum.ERROR.getAlertType(),
                        "Login Error",
                        "You have empty fields!",
                        "Make sure to complete them");
                if (result) {
                    return;
                }
            }

            UserDto userDto = userService.logTheUserIn(login, pass);
            if(userDto==null){
                boolean result = DisplayAlert.displayAlert(AlertTypeEnum.ERROR.getAlertType(),
                        "Login Error",
                        "We didn't found any user with this login and password!",
                        "Make sure to complete them");
                if (result) {
                    return;
                }
            }

            UserSession.createSession(userDto);

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            context.publishEvent(new StageReadyEvent(stage, HomePageController.class));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void RegisterUser() {
        try {

            String emailFieldRegisterText = emailFieldRegister.getText();
            String nameFieldRegisterText = nameFieldRegister.getText();
            String surnameFieldRegisterText = surnameFieldRegister.getText();
            String positionFieldRegisterText = positionFieldRegister.getText();
            String passwordFieldRegisterText = passwordFieldRegister.getText();
            String repeatPasswordFieldRegisterText = repeatPasswordFieldRegister.getText();

            if (emailFieldRegisterText.isBlank() || nameFieldRegisterText.isBlank() || surnameFieldRegisterText.isBlank() || positionFieldRegisterText.isBlank() || passwordFieldRegisterText.isBlank() || repeatPasswordFieldRegisterText.isBlank()) {
                boolean result = DisplayAlert.displayAlert(AlertTypeEnum.ERROR.getAlertType(),
                        "Register Error",
                        "You have empty fields!",
                        "Make sure to complete them");
                if (result) {
                    return;
                }
            }
            if (!passwordFieldRegisterText.equals(repeatPasswordFieldRegisterText)){
                boolean result = DisplayAlert.displayAlert(AlertTypeEnum.ERROR.getAlertType(),
                        "Register Error",
                        "Your passwords are not the same",
                        "Make sure to make them equal");
                if (result) {
                    return;
                }
            }
            UserDto userDto = new UserDto();
            userDto.setEmail(emailFieldRegisterText);
            userDto.setName(nameFieldRegisterText);
            userDto.setSurname(surnameFieldRegisterText);
            userDto.setPosition(positionFieldRegisterText);
            userDto.setPassword(passwordFieldRegisterText);
            userDto.setCreationTime(LocalDateTime.now());
            userDto.setSystemRole("User");
            userService.save(userDto);

            registrationVBox.setVisible(false);
            loginVBox.setVisible(true);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

}