package app.studyjko.application;

import app.studyjko.controller.LoginRegistrationController;
import app.studyjko.StudyjkoApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.io.IOException;

public class JavaFxApplication extends Application {
    private ConfigurableApplicationContext context;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        ApplicationContextInitializer<GenericApplicationContext> initializer =
                contextu -> {
                    contextu.registerBean(Application.class, () -> JavaFxApplication.this);
                    contextu.registerBean(Parameters.class, this::getParameters); // for demonstration, not really needed
                };
        context = new SpringApplicationBuilder()
                .sources(StudyjkoApplication.class)
                .initializers(initializer)
                .run(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        context.publishEvent(new StageReadyEvent(stage, LoginRegistrationController.class));
    }

    @Override
    public void stop() {
        this.context.close();
        Platform.exit();
    }

}
