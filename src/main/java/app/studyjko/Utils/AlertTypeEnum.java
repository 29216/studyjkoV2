package app.studyjko.Utils;

import javafx.scene.control.Alert;
import lombok.Getter;

public enum AlertTypeEnum {

    CONFIRM(Alert.AlertType.CONFIRMATION),
    ERROR(Alert.AlertType.ERROR),
    INFORMATION(Alert.AlertType.INFORMATION),
    WARNING(Alert.AlertType.WARNING),
    NONE(Alert.AlertType.NONE);

    @Getter
    private final Alert.AlertType alertType;

    AlertTypeEnum(Alert.AlertType alertType) {
        this.alertType = alertType;
    }
}
