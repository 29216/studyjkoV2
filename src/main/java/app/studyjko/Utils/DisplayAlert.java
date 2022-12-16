package app.studyjko.Utils;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.StageStyle;

import java.util.Optional;

public class DisplayAlert {
    private DisplayAlert() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * @return true if user clicked 'OK' or false if something gone wrong
     */
    public static boolean displayAlert(Alert.AlertType alertType, String title, String headText, String contentText) {
        Alert alert = new Alert(alertType);
        alert.initStyle(StageStyle.UNDECORATED);
        alert.setTitle(title);
        alert.setHeaderText(headText);
        alert.setContentText(contentText);
        Optional<?> res = alert.showAndWait();
        return res.isPresent() && res.get() == ButtonType.OK;
    }
}
