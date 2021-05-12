package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
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
    public static int SUCCESS = 1;
    public static int LOSS = 3;
    public int a = gameLogic.randomer();
    public int b = gameLogic.randomer();
    public int c = 0;
    public String convert = Integer.toBinaryString(a);
    public String convert1 = Integer.toBinaryString(b);
    public int convertINt = Integer.parseInt(convert);
    public int convertINt1 = Integer.parseInt(convert1);
    public int count = 0;
    public int count1 = 0;
    
    public void initialize(){
        gameLogic.alarm();
        number1.setText(convert);
        number2.setText(convert1);
        rightAnswers.setText(String.valueOf(count));
        falseAnswers.setText(String.valueOf(count1));
        chain = new PositiveHandler(new NegativeHandler(null));
    }
    public void countGenerat(){
        count = 0;
        count1 = 0;
        rightAnswers.setText(String.valueOf(count));
        falseAnswers.setText(String.valueOf(count1));
    }
    public void goodAnswerGenerat(){
        rightAnswers.setText(String.valueOf(count));
        goodCircle.setVisible(true);
        plusBall.setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000/*Time in millis*/,e->
        {
            Platform.runLater(()->
            {
                goodCircle.setVisible(false);
                plusBall.setVisible(false);
            }/*Runnable*/);
        }/*ActionListener*/);
        timer.setRepeats(false);
        timer.start();
    }
    public void badAnswerGenerat(){
        falseAnswers.setText(String.valueOf(count1));
        badCircle.setVisible(true);
        minusBall.setVisible(true);
        javax.swing.Timer timer = new javax.swing.Timer(1000/*Time in millis*/,e->
        {
            Platform.runLater(()->
            {
                badCircle.setVisible(false);
                minusBall.setVisible(false);
            }/*Runnable*/);
        }/*ActionListener*/);
        timer.setRepeats(false);
        timer.start();
    }
    public void handleLogic(){
        convertINt = convertINt1;
        number1.setText(String.valueOf(convertINt));
        c = gameLogic.randomer();
        convert = Integer.toBinaryString(c);
        convertINt1 = Integer.parseInt(convert);
        number2.setText(String.valueOf(convertINt1));
        //number2.setVisible(false);
        //number1.setVisible(false);
        number2.setEffect(new GaussianBlur(500));
        number1.setEffect(new GaussianBlur(500));
        javax.swing.Timer timer1 = new javax.swing.Timer(1000/*Time in millis*/,e->
        {
            Platform.runLater(()->
            {
                number2.setEffect(null);
                number1.setEffect(null);
                // number2.setVisible(true);
                //number1.setVisible(true);
            }/*Runnable*/);
        }/*ActionListener*/);
        timer1.setRepeats(false);
        timer1.start();
    }
    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.W){
            if(convertINt1 >= convertINt ){
                count++;
                goodAnswerGenerat();
            }
            else {
                count1++;
                badAnswerGenerat();
            }
            handleLogic();
            if(count == 10 ){
                videos.getEngine().load("https://www.youtube.com/watch?v=ptbrmoSN9IM");
                chain.process(SUCCESS);
                countGenerat();
            }
            if(count1 == 6 ){
                chain.process(LOSS);
                countGenerat();
            }
        }
        if(event.getCode() == KeyCode.S){
            if (convertINt1 <= convertINt) {
                count++;
                goodAnswerGenerat();
            }
            else {
                count1++;
                badAnswerGenerat();
            }
            handleLogic();
            if(count == 10 ){
                Platform.runLater(()->
                {
                    videos.getEngine().load("https://www.youtube.com/watch?v=ptbrmoSN9IM");
                }/*Runnable*/);
                chain.process(SUCCESS);
                countGenerat();
            }
            if(count1 == 6 ){
                // videos.getEngine().load("https://youtu.be/0kLTU4w1zRg");
                chain.process(LOSS);
                countGenerat();
            }
        }

    }
}
