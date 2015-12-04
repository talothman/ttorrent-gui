/**
 * Created by Talal on 12/3/2015.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class MainInterface extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("maininterface.fxml"));

        Scene scene = new Scene(root, 300, 275);

        primaryStage.setTitle("ttorrent GUI");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
