package sample;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import model.GameLogic;
import model.Handler;
import model.NegativeHandler;
import model.PositiveHandler;
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
    public int count ;
    public int count1;
    public int chainNum = 0;
    public void alarm (){
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Инструкция!");
        alert1.setHeaderText("Игровые возможности направлены на закрепление навыка различать двоичные записи чисел\n" +
                "Геймплей: на экране появляются двоичные цифры, необходимо нажать W, если появившаяся цифра больше предыдущей или S - если меньше");
        ButtonType replay = new ButtonType("Начать игру", ButtonBar.ButtonData.OK_DONE);
        alert1.getButtonTypes().clear();
        alert1.getButtonTypes().addAll(replay);
        Optional<ButtonType> option = alert1.showAndWait();
        option.get();
    }

    public void initialize(){
        alarm();
        number1.setText(gameLogic.getConvert());
        number2.setText(gameLogic.getConvert1());
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

    public void increaseCount(){
        count++;
    }

    public void increaseCount1(){
        count1++;
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
        gameLogic.setConvertINt(gameLogic.getConvertINt1());
        number1.setText(gameLogic.getConvert());
        gameLogic.setConvert(Integer.toBinaryString(gameLogic.randomer()));
        gameLogic.setConvertINt1(Integer.parseInt(gameLogic.getConvert()));
        number2.setText(gameLogic.getConvert());
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
    }
    public void hanleGenerat(){
        if(count == 10 ){
            chainNum = 1;
            countGenerat();
            chain.process(chainNum);
        }
        if(count1 == 6 ){
            chainNum = 3;
            countGenerat();
            chain.process(chainNum);
        }
    }
    public void handle(KeyEvent event){
        if(event.getCode() == KeyCode.W){
            if(gameLogic.check()){
                increaseCount();
                goodAnswerGenerat();
            }
            else {
                increaseCount1();
                badAnswerGenerat();
            }
            handleLogic();
            hanleGenerat();
        }
        if(event.getCode() == KeyCode.S){
            if(!gameLogic.check()) {
                increaseCount();
                goodAnswerGenerat();
            }
            else {
                increaseCount1();
                badAnswerGenerat();
            }
            handleLogic();
            hanleGenerat();
        }

    }
}
