package app.studyjko.application;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class PrimaryStageInitializer implements ApplicationListener<StageReadyEvent> {
    private final FxWeaver fxWeaver;
    private double xOffset = 0;
    private double yOffset = 0;

    @Autowired
    public PrimaryStageInitializer(FxWeaver fxWeaver) {
        this.fxWeaver = fxWeaver;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {
        Stage stage = event.stage;
        Class<?> clazz = event.clazz;

        try {
            stage.initStyle(StageStyle.UNDECORATED);
        } catch (Exception ignored){}

        Parent root = fxWeaver.loadView(clazz);
        Scene scene = new Scene(root, 1200, 800);

        scene.setOnMousePressed(eventt -> {
            xOffset = eventt.getSceneX();
            yOffset = eventt.getSceneY();
        });
        scene.setOnMouseDragged(eventt -> {
            stage.setX(eventt.getScreenX() - xOffset);
            stage.setY(eventt.getScreenY() - yOffset);
        });

        stage.setScene(scene);
        stage.show();
    }
}
