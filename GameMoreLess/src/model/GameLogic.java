package model;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import sample.Controller;

import java.util.Optional;

public class GameLogic {
    public int a = randomer();
    public int b = randomer();
    public int c = 0;
    public String convert = Integer.toBinaryString(a);
    public String convert1 = Integer.toBinaryString(b);
    public int convertINt = Integer.parseInt(convert);
    public int convertINt1 = Integer.parseInt(convert1);
    public boolean GREAT;
    public boolean NOTGREAT;
    public int count = 0;
    public int count1 = 0;
    public int randomer(){
        int random = (int) ( 5 + Math.random() * 40 );
        return random;
    }
    public GameLogic(){

    }
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
    public void initial(){
    }

    public int getCount() {
        return count;
    }

    public int getCount1() {
        return count1;
    }

    public void WTrue(){

    }

}
