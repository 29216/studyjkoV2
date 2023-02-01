package app.studyjko.controller;

import app.studyjko.model.CdEntity;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import javax.swing.text.html.ImageView;
@Component
@FxmlView("CDBox.fxml")
public class CDBoxController {

    @FXML
    private ImageView imageCover;

    @FXML
    private Label titleAlbum;

    @FXML
    private Label author;

    public void setCD(CdEntity cdEntity) {
        titleAlbum.setText(cdEntity.getTitle());
        // just for placeholder of author
        author.setText(String.valueOf(cdEntity.getCreatorId()));
    }
}
