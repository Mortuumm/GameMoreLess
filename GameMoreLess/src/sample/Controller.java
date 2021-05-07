package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import model.GameLogic;
import model.Handler;
import model.NegativeHandler;
import model.PositiveHandler;

import javax.swing.*;
import java.util.Optional;

public class Controller {
    GameLogic gameLogic = new GameLogic();
    public  WebView videos;
    public Circle goodCircle;
    public Circle badCircle;
    public Text plusBall;
    public Text minusBall;
    public Handler chain;
    public Label rightAnswers;
    public Button number1;
    public Button number2;
    public Label falseAnswers;

    public void initialize(){
        gameLogic.initial();
    }

    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.W){
            gameLogic.run1();
        }
        if(event.getCode() == KeyCode.S){
            gameLogic.run2();
        }
    }
}
