package sample;

import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaPlayer.Status;

public class VideoBar extends HBox {
    Slider timeSlider=new Slider();
    Slider volSlider=new Slider();
    Button button=new Button("||");
    Label volume=new Label("volume");
    MediaPlayer player;

    public VideoBar(MediaPlayer play) {
        player=play;
//        css stying things
        setAlignment(Pos.CENTER);
        setPadding(new Insets(5,10,5,10));
        volSlider.setPrefWidth(70.0);
        volSlider.setMinWidth(30.0);
        volSlider.setValue(100);
        HBox.setHgrow(timeSlider,Priority.ALWAYS);
        button.prefWidth(30);
        getChildren().add(button);
        getChildren().add(timeSlider);
        getChildren().add(volume);
        getChildren().add(volSlider);
//        make pause and play button work
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Status status=player.getStatus();
                if(status==status.PLAYING){
                    if(player.getCurrentTime().greaterThanOrEqualTo(player.getTotalDuration())){
                        player.seek(player.getStartTime());
                        player.play();
                    }
                    else
                    {
                        player.pause();
                        button.setText(">");
                    }
                }
                if(status==status.PAUSED||status==status.STOPPED){
                    player.play();
                    button.setText("||");
                }



            }
        });
        player.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                moveSlider();

            }
        });
        volSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if(volSlider.isPressed()){
                    player.setVolume(volSlider.getValue()/100);
                }

            }
        });



    }
    private void moveSlider(){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                timeSlider.setValue(player.getCurrentTime().toMillis()/player.getTotalDuration().toMillis()*100);



            }
        });
    }
}
