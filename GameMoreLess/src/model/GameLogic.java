package model;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import sample.Controller;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.*;
import java.util.Optional;

public class GameLogic {
   
    public int a = randomer();
    public int b = randomer();
    
    public String getOp1(){
        return Integer.toBinaryString(a);
    }
  
     public String getOp2(){
        return Integer.toBinaryString(b);
    } 
    
    public boolean check(char c){
        return ((a>b)&& (c=='>'))?true:false;
    }
    
  
    private int randomer(){
        int random = (int) ( 5 + Math.random() * 40 );
        return random;
    }
} //необходимости в остальных методах не вижу
