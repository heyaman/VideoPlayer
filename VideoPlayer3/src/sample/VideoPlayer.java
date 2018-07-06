package sample;

import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
//pane :we can called it pane use as view
//due to BorderPane: nodes are arranged in top,bottom,left,right,centre
//layout container classes called pane`

public class VideoPlayer extends BorderPane {
//    media,mediaPlayer,mediaView are used to play,control,view of media
    Media media;
    MediaPlayer mediaPlayer;
    MediaView mediaView;
    Pane pane;
    VideoBar bar;

    public VideoPlayer(String path) {
        media=new Media(path);
        mediaPlayer=new MediaPlayer(media);
        mediaView=new MediaView(mediaPlayer);
        pane=new Pane();


        pane.getChildren().add(mediaView);
//        one line remaining
        setCenter(pane);

//        add video bar here
        bar=new VideoBar(mediaPlayer);
        setBottom(bar );
        mediaPlayer.play();

    }
}
