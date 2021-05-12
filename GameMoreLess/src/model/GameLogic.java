package model;

import javafx.application.Platform;
import javafx.scene.control.*;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import sample.Controller;

import java.util.Optional;

public class GameLogic {
    public int randomer(){
        int random = (int) ( 5 + Math.random() * 40 );
        return random;
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
}
