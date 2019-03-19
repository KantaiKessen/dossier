import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TutorController {
    @FXML
    private TextArea addComms;
    @FXML
    private CheckBox friday;
    @FXML
    private CheckBox thursday;
    @FXML
    private CheckBox wednesday;
    @FXML
    private CheckBox tuesday;
    @FXML
    private CheckBox monday;
    @FXML
    private Button submitButton;
    @FXML
    private ChoiceBox subjectChoice;
    @FXML
    private Button backButton;
    @FXML
    private Button checkButton;
    @FXML
    private TextField firstNameField;
    @FXML
    private TextField lastNameField;
    @FXML
    private TextField gradeField;
    @FXML
    private ChoiceBox startTimeChoice;
    @FXML
    private ChoiceBox endTimeChoice;
    @FXML
    private Pane pane;

    @FXML
    public void handleButtons(ActionEvent e) throws IOException {
        if (e.getSource() == backButton)
            changeScene("welcolm.fxml");
        if (e.getSource() == checkButton)
            changeScene("studentview.fxml");
        if (e.getSource() == submitButton) {

            try {

                FTPUploader ftp = new FTPUploader("niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");

            } catch (Exception ea) {
                ea.printStackTrace();
                AlertBox.display("Database is down", "The database is down and cannot be accessed.");
            }
        }

    }

    // FIXME: 03/18/2019
    public void changeScene(String fxml) throws IOException {
        Stage buttonStage;
        buttonStage = (Stage) pane.getScene().getWindow();
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        buttonStage.getScene().setRoot(pane);
    }
}
