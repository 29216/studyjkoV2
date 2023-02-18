package app.studyjko.controller;

import app.studyjko.ParamKey;
import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.cd.CdDto;
import app.studyjko.data.cd.CdService;
import app.studyjko.data.parms.ParmsDto;
import app.studyjko.data.parms.ParmsService;
import app.studyjko.model.CdEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ResourceBundle;


@Component
@FxmlView("RulesPage.fxml")
@RequiredArgsConstructor
public class RulesController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button manipulateCd;

    @FXML
    private Label rulesField;


    private final ApplicationContext context;

    private final ParmsService parmsService;

    private final FileChooser fileChooser = new FileChooser();

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

        ParmsDto parmsDto = parmsService.getParmsByName("rules");
        if (parmsDto != null) {
           rulesField.setText(parmsDto.getValue());
        }

    }

    public void GoBack(ActionEvent event) {
        UserSession.getInstance().getParameters().remove(ParamKey.CD_ID_TO_DISPLAY);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        context.publishEvent(new StageReadyEvent(stage, HomePageController.class));
    }

    public void addRules(ActionEvent event) throws IOException {
        fileChooser.setTitle("Get rules");
        File file = fileChooser.showOpenDialog(null);
        if (file != null && file.canRead()) {
            Path fileName = Path.of(file.getAbsolutePath());
            String content = Files.readString(fileName);
            rulesField.setText(content);
            parmsService.saveNewRules(content);
        }
    }

}