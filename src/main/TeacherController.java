package main;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
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
    private Button backButton;
    @FXML
    public void controlButtons(ActionEvent e) throws IOException {
        if(e.getSource() == loginButton){
            FTPActions.downloadFiles();
            if(LoginAction.loginAction(usernameBox.getText(),passwordBox.getText())){
                    changeScene("matchview.fxml");
            }
        }
        else if(e.getSource() == signUpButton){
            FileWriter fw = new FileWriter(new File("teacher"), true);
            fw.write("\n" + usernameSignBox.getText().replaceAll("\\s","") + ":"
                    + SecurityFeatures.getMD5(passwordSignBox.getText().replaceAll("\\s", "")) + ":"
                    + emailSignBox.getText().replaceAll("\\s", ""));
            fw.close();
            FTPActions.uploadFiles();
            usernameSignBox.clear();
            passwordSignBox.clear();
            emailSignBox.clear();;
            ConfirmBox.display("Please Login", "Please login.");
        }
        else if(e.getSource() == backButton)
            changeScene("welcolm.fxml");
    }

    public void changeScene(String fxml) throws IOException {
        Stage buttonStage = (Stage) teacherLogPane.getScene().getWindow();
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        buttonStage.getScene().setRoot(pane);
    }
}
