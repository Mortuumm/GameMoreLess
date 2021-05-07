package model;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import sample.Controller;

import java.util.Optional;

public class GameLogic {
    Controller cntr = new Controller();
    public WebView videos = cntr.videos;// а это не View
    public Circle goodCircle = cntr.goodCircle;// а это не View
    public Circle badCircle = cntr.badCircle;// а это не View
    public Text plusBall = cntr.plusBall;// а это не View
    public Text minusBall = cntr.minusBall;// а это не View
    public Handler chain = cntr.chain;// а это не View
    public Label rightAnswers = cntr.rightAnswers;// а это не View
    public Button number1 = cntr.number1;// а это не View
    public Button number2 = cntr.number2;// а это не View
    public Label falseAnswers = cntr.falseAnswers;// а это не View
    public static int SUCCESS = 1;// эти значения как раз надо возвращать для обраблтке в Контроллере по результатам проверки
    public static int LOSS = 3;
    public int a = (int) ( 5 + Math.random() * 40 );//в метод
    public int b = (int) ( 5 + Math.random() * 40 );//в метод
    public int c = 0;
    public String convert = Integer.toBinaryString(a);// а это не View
    public String convert1 = Integer.toBinaryString(b);// а это не View
    public int convertINt = Integer.parseInt(convert);// а это не View
    public int convertINt1 = Integer.parseInt(convert1);// а это не View
    public int count = 0;
    public int count1 = 0;
    public void initial(){
        Alert alert1 = new Alert(Alert.AlertType.INFORMATION);
        alert1.setTitle("Инструкция!");
        alert1.setHeaderText("Игровые возможности направлены на закрепление навыка различать двоичные записи чисел\n" +
                "Геймплей: на экране появляются двоичные цифры, необходимо нажать W, если появившаяся цифра больше предыдущей или S - если меньше");
        ButtonType replay = new ButtonType("Начать игру", ButtonBar.ButtonData.OK_DONE);
        alert1.getButtonTypes().clear();
        alert1.getButtonTypes().addAll(replay);
        Optional<ButtonType> option = alert1.showAndWait();
        option.get();
        number1.setText(convert);
        number2.setText(convert1);
        rightAnswers.setText(String.valueOf(count));
        falseAnswers.setText(String.valueOf(count1));
        chain = new PositiveHandler(new NegativeHandler(null));
    }
    public void run1(){
        if(convertINt1 >= convertINt ){
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
        c = (int) ( 5 + Math.random() * 40 );
        convert = Integer.toBinaryString(c);
        convertINt1 = Integer.parseInt(convert);
        number2.setText(String.valueOf(convertINt1));
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
            Platform.runLater(()->
            {
                videos.getEngine().load("https://youtu.be/0kLTU4w1zRg");
            }/*Runnable*/);
            chain.process(LOSS);
            count = 0;
            count1 = 0;
            rightAnswers.setText(String.valueOf(count));
            falseAnswers.setText(String.valueOf(count1));
        }
    }
    public void run2(){
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
        c = (int) ( 5 + Math.random() * 40 );
        convert = Integer.toBinaryString(c);
        convertINt1 = Integer.parseInt(convert);
        number2.setText(String.valueOf(convertINt1));
        if(count == 10 ){
            Platform.runLater(()->
            {
                videos.getEngine().load("https://www.youtube.com/watch?v=ptbrmoSN9IM");
            }/*Runnable*/);
            // videos.getEngine().load("https://www.youtube.com/watch?v=ptbrmoSN9IM");
            chain.process(SUCCESS);
            count = 0;
            count1 = 0;
            rightAnswers.setText(String.valueOf(count));
            falseAnswers.setText(String.valueOf(count1));
        }
        if(count1 == 6 ){
            Platform.runLater(()->
            {
                videos.getEngine().load("https://youtu.be/0kLTU4w1zRg");
            }/*Runnable*/);
            // videos.getEngine().load("https://youtu.be/0kLTU4w1zRg");
            chain.process(LOSS);
            count = 0;
            count1 = 0;
            rightAnswers.setText(String.valueOf(count));
            falseAnswers.setText(String.valueOf(count1));
        }
    }
}
