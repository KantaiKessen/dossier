import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("signIn");
        primaryStage.setOnCloseRequest(e -> {
            e.consume();
            closeProgram();
        });
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("welcolm.fxml"));
        primaryStage.setTitle("PTC");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }

    private void closeProgram() {
        boolean answer = ConfirmBox.display("Close Program",
                "       Are you sure you want to close this program?        ");
        if (answer)
            primaryStage.close();
    }

    public void changeScene(String fxml) throws Exception {
        Parent pane = FXMLLoader.load(
                getClass().getResource(fxml));
        primaryStage.getScene().setRoot(pane);
    }
}
