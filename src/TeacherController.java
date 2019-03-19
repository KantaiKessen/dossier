import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class TeacherController {
    @FXML private Button loginButton;
    @FXML private Button signUpButton;
    @FXML private TextField emailSignBox;
    @FXML private Pane teacherLogPane;
    @FXML
    private TextField usernameBox;
    @FXML
    private PasswordField passwordBox;
    @FXML
    private TextField usernameSignBox;
    @FXML
    private TextField passwordSignBox;
    @FXML
    public void controlButtons(ActionEvent e){
        if(e.getSource() == loginButton){

        }
        if(e.getSource() == signUpButton){

        }
    }

    public void changeScene(String fxml) throws IOException {
        Stage buttonStage = (Stage) teacherLogPane.getScene().getWindow();
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        buttonStage.getScene().setRoot(pane);
    }
}
