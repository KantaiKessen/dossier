import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class WelcomeController {
    @FXML
    private Button studentButton;
    @FXML
    private Button teacherButton;
    @FXML
    private Button tutorButton;

    @FXML
    public void handleButtons(ActionEvent e) throws IOException {
        if (e.getSource() == studentButton)
            changeScene("studentreq.fxml");
        if (e.getSource() == teacherButton)
            changeScene("teacherlog.fxml");
        if (e.getSource() == tutorButton)
            changeScene("tutorreq.fxml");
    }

    public void changeScene(String fxml) throws IOException {
        Stage buttonStage = (Stage) studentButton.getScene().getWindow();
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        buttonStage.getScene().setRoot(pane);
    }
}
