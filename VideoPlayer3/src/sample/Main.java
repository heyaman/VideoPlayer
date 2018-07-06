package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VideoPlayer videoPlayer=new VideoPlayer("file:///G:/ar%20rehman/Tum%20Ho%20-%20Rockstar_HD.mp4");
        Scene scene=new Scene(videoPlayer,854,510,Color.AQUA);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
