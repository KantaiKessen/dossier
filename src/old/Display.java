package old;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  The display is the centerpiece of the application. It displays JavaFX windows and has the user interact with it.
 *
 * @author  Kevin Liu
 * @version 0.0.1
 */
public class Display extends Application {
    private Button loginButton, signUpButton;
    private Label signInLabel;
    private Stage window;
    private Scene signInScene, loginScene;
    Scene registerScene;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("signIn");
        window.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        signInLabel = new Label("Welcome to Study Helper");

        loginButton = new Button("Login");
        loginButton.setOnAction(e -> {
            window.setScene(loginScene());
            window.show();
        });

        signUpButton = new Button("Sign Up");
        signUpButton.setOnAction(e -> System.out.print('y'));

        VBox signInLayout = new VBox(20);
        signInLayout.setAlignment(Pos.CENTER);
        signInLayout.getChildren().addAll(signInLabel, loginButton, signUpButton);

        signInScene = new Scene(signInLayout, 300, 250);
        window.setScene(signInScene);
        window.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Close Program",
                "Are you sure you want to close this program?");
        if (answer)
            window.close();
    }

    private Scene loginScene() {
        if (loginScene == null) {
            Label uNameLabel = new Label("Username: ");
            TextField uNameInput = new TextField();
            uNameInput.setPromptText("Username");
            Label passwdLabel = new Label("Password: ");
            TextField passwdInput = new TextField();
            passwdInput.setPromptText("Password");
            Button loginButton = new Button("Login");
            loginButton.setOnAction(e -> loginAction(uNameInput.getText(), passwdInput.getText()));
            Button backButton = new Button("Back");
            backButton.setOnAction(e -> {
                window.setScene(signInScene);
                window.show();
            });
            GridPane grid = new GridPane();
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(10);
            grid.setHgap(110);
            grid.setConstraints(uNameLabel, 0, 0);
            grid.setConstraints(uNameInput, 1, 0);
            grid.setConstraints(passwdLabel, 0, 1);
            grid.setConstraints(passwdInput, 1, 1);
            grid.setConstraints(backButton, 0, 3);
            grid.setConstraints(loginButton, 1, 3);
            grid.getChildren().addAll(uNameLabel, uNameInput, passwdLabel, passwdInput, loginButton, backButton);
            loginScene = new Scene(grid, 400, 300);
        }
        return loginScene;
    }

    private void loginAction(String name, String pass){
        int numLines = 0;

        try {
            FTPDownloader ftp = new FTPDownloader(
                    "niokiryth.asuscomm.com", "dbAccess", "dbAccessPassword!");
            ftp.downloadFile("/etc/users", "users");
            Scanner scanner = new Scanner(new File("users"));
            while(scanner.hasNext()){
                numLines++;
                scanner.next();
            }
            scanner.close();
            scanner = new Scanner(new File("users"));
            String[][] userData = new String[2][];
            userData[0] = new String[numLines];
            userData[1] = new String[numLines];
            for(int i = 0; i < numLines; i++){
                String[] data = scanner.next().split(":");
                userData[0][i] = data[0];
                userData[1][i] = data[1];
            }
            if(!isInUserFile(name, userData)){
                AlertBox.display("User not found", "The user does not exist");
            }
        }
        catch(FileNotFoundException eb){
            eb.printStackTrace();
        }
         catch(Exception ea){
            ea.printStackTrace();
            AlertBox.display("Database is down", "The database is down and cannot be accessed." +
                    "Please call the officer of the deck in any case not covered by instructions");
        }

    }
    private boolean isInUserFile(String name, String[][] a){
        for(String x : a[0]){
            if(x.equals(name)){
                return true;
            }
        }
        return false;
    }
}
