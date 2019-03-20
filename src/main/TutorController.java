package main;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

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
    private TableView<Person> tutors;

    @FXML
    public void handleButtons(ActionEvent e) throws IOException {
        if (e.getSource() == backButton)
            changeScene("welcolm.fxml");
        if (e.getSource() == checkButton)
            changeScene("tutorview.fxml");
        if (e.getSource() == submitButton) {
            FTPActions.downloadFiles();
            FileWriter fw = new FileWriter(new File("tutor"), true);
            fw.write("\n" + firstNameField.getText() + ":" + lastNameField.getText() + ":" + gradeField.getText() + ":"
                    + subjectChoice.getValue().toString() + ":" + "false" + ":" + startTimeChoice.getValue().toString()
                    + ":" + endTimeChoice.getValue().toString());
            fw.close();
            FTPActions.uploadFiles();
        }
    }
    @FXML
    public void tutorResetButton(ActionEvent e) throws IOException{
        Scanner scanner = new Scanner(new File("tutor"));
        int count = 0;
        while(scanner.hasNext()){
            count++;
            scanner.next();
        }
        Person[] persons = new Person[count];
        scanner.close();
        scanner = new Scanner(new File("tutor"));
        for(int i = 0; i < count; i++){
            String s = scanner.next();
            String[] st = s.split(":");
            persons[i] = new Person(st[0], st[1], Integer.parseInt(st[2]),
                    st[3], st[4].equals("true"));
        };
        ObservableList<Person> data = tutors.getItems();
        data.clear();
        data.addAll(persons);
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
