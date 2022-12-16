package app.studyjko.application;

import javafx.stage.Stage;
import org.springframework.context.ApplicationEvent;

public class StageReadyEvent extends ApplicationEvent {

    public final Stage stage;
    public final Class<?> clazz;

    public StageReadyEvent(Stage stage, Class<?> clazz) {
        super(stage);
        this.stage = stage;
        this.clazz = clazz;
    }
}