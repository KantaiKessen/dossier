import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    Stage primaryStage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("welcolm.fxml"));
        primaryStage.setTitle("PTC");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void changeScene(String fxml) throws Exception{
            Parent pane = FXMLLoader.load(
                    getClass().getResource(fxml));
            primaryStage.getScene().setRoot(pane);
    }
}
