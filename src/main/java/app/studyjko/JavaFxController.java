package app.studyjko;

import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.ResourceBundle;

@Component
public final class JavaFxController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button maximizedScreenButton;
    @FXML
    private Button minimizeButton;

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

        maximizedScreenButton.setOnMouseClicked(mouseEvent -> {
            Stage obj = (Stage) maximizedScreenButton.getScene().getWindow();
            if(!obj.isMaximized()) {
                obj.setMaximized(true);
            } else {
                obj.setWidth(1240);
                obj.setHeight(843);
            }

        });

    }


}
