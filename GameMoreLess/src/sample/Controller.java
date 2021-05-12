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

    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.W){
                    if(gameLogic.convertINt1 >= gameLogic.convertINt ){
                        rightAnswers.setText(String.valueOf(gameLogic.getCount()));
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
                    else {
                        gameLogic.getCount1();
                        falseAnswers.setText(String.valueOf(gameLogic.getCount1()));
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
            if(count == 10 ){
                videos.getEngine().load("https://www.youtube.com/watch?v=ptbrmoSN9IM");
                chain.process(SUCCESS);
                count = 0;
                count1 = 0;
                rightAnswers.setText(String.valueOf(count));
                falseAnswers.setText(String.valueOf(count1));
            }
            if(count1 == 6 ){
                chain.process(LOSS);
                count = 0;
                count1 = 0;
                rightAnswers.setText(String.valueOf(count));
                falseAnswers.setText(String.valueOf(count1));
            }
        }
        if(event.getCode() == KeyCode.S){
            if (convertINt1 <= convertINt) {
                count++;
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
            else {
                count1++;
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
            convertINt = convertINt1;
            number1.setText(String.valueOf(convertINt));
            c = gameLogic.randomer();
            convert = Integer.toBinaryString(c);
            convertINt1 = Integer.parseInt(convert);
            number2.setText(String.valueOf(convertINt1));
            number2.setEffect(new GaussianBlur(500));
            number1.setEffect(new GaussianBlur(500));
            javax.swing.Timer timer1 = new javax.swing.Timer(1000/*Time in millis*/,e->
            {
                Platform.runLater(()->
                {
                    number2.setEffect(null);
                    number1.setEffect(null);
                }/*Runnable*/);
            }/*ActionListener*/);
            timer1.setRepeats(false);
            timer1.start();
            if(count == 10 ){
                Platform.runLater(()->
                {
                    videos.getEngine().load("https://www.youtube.com/watch?v=ptbrmoSN9IM");
                }/*Runnable*/);
                chain.process(SUCCESS);
                count = 0;
                count1 = 0;
                rightAnswers.setText(String.valueOf(count));
                falseAnswers.setText(String.valueOf(count1));
            }
            if(count1 == 6 ){
                chain.process(LOSS);
                count = 0;
                count1 = 0;
                rightAnswers.setText(String.valueOf(count));
                falseAnswers.setText(String.valueOf(count1));
            }
        }
    }
}
