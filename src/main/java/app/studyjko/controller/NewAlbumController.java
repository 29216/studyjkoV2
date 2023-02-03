package app.studyjko.controller;

import app.studyjko.ParamKey;
import app.studyjko.UserSession;
import app.studyjko.Utils.AlertTypeEnum;
import app.studyjko.Utils.DisplayAlert;
import app.studyjko.application.StageReadyEvent;
import app.studyjko.data.cd.CdDto;
import app.studyjko.data.cd.CdService;
import app.studyjko.model.CdEntity;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.RequiredArgsConstructor;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;



@Component
@FxmlView("NewAlbumPage.fxml")
@RequiredArgsConstructor
public class NewAlbumController implements Initializable {
    @FXML
    private Button closeButton;

    @FXML
    private Button minimizeButton;

    @FXML
    private Button manipulateCd;

    @FXML
    private TextField creatorField;
    @FXML
    private TextField albumField;

    @FXML
    private TextField titleField;

    @FXML
    private TextField linkField;

    private final ApplicationContext context;

    private final CdService cdService;

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

        if (UserSession.getInstance().getParameters().containsKey(ParamKey.CD_ID_TO_DISPLAY)){
            CdEntity cdEntity = cdService.findCdById(Long.valueOf(UserSession.getInstance().getParameters().get(ParamKey.CD_ID_TO_DISPLAY)));
            if (cdEntity == null) {
                return;
            }
            creatorField.setText(cdEntity.getCreator());
            albumField.setText(cdEntity.getAlbum());
            titleField.setText(cdEntity.getTitle());
            linkField.setText(cdEntity.getLink());
            manipulateCd.setText("Update");
        }

    }

    public void GoBack(ActionEvent event) {
        UserSession.getInstance().getParameters().remove(ParamKey.CD_ID_TO_DISPLAY);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        context.publishEvent(new StageReadyEvent(stage, HomePageController.class));
    }

    public void Add(ActionEvent event) {//AddButton

        String creatorFieldText = creatorField.getText();
        String albumFieldText = albumField.getText();
        String titleFieldText = titleField.getText();
        String linkFieldText = linkField.getText();

        if (creatorFieldText.isBlank() || albumFieldText.isBlank() || titleFieldText.isBlank() || linkFieldText.isBlank()) {
            boolean result = DisplayAlert.displayAlert(AlertTypeEnum.ERROR.getAlertType(),
                    "Content Error",
                    "You have empty fields!",
                    "Make sure to complete them");
            if (result) {
                return;
            }
        }
        CdDto cdDto;
        if (UserSession.getInstance().getParameters().containsKey(ParamKey.CD_ID_TO_DISPLAY)){
            CdEntity cdEntity = cdService.findCdById(Long.valueOf(UserSession.getInstance().getParameters().get(ParamKey.CD_ID_TO_DISPLAY)));
            cdDto = cdService.mapEntityToDto(cdEntity);
        } else
            cdDto = new CdDto();
        cdDto.setCreationTime(LocalDateTime.now());
        cdDto.setModificationTime(LocalDateTime.now());
        cdDto.setLink(linkFieldText);
        cdDto.setTitle(titleFieldText);
        cdDto.setUserId(UserSession.getInstance().getUserDto().getId());
        cdDto.setCreator(creatorFieldText);
        cdDto.setAlbum(albumFieldText);
        cdService.save(cdDto);
        DisplayAlert.displayAlert(AlertTypeEnum.INFORMATION.getAlertType(),
                "Content ",
                UserSession.getInstance().getParameters().containsKey(ParamKey.CD_ID_TO_DISPLAY) ? "You have updated cd!" : "You have added cd!",
                "Thank you");
        UserSession.getInstance().getParameters().remove(ParamKey.CD_ID_TO_DISPLAY);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        context.publishEvent(new StageReadyEvent(stage, HomePageController.class));
    }

}