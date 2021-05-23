package model;

import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import sample.Controller;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.*;
import java.util.Optional;

public class GameLogic {
    public int chainNum = 0;
    public int a = randomer();
    public int b = randomer();
    public int c = 0;
    public String convert = Integer.toBinaryString(a);
    public String convert1 = Integer.toBinaryString(b);
    public int convertINt = Integer.parseInt(convert);
    public int convertINt1 = Integer.parseInt(convert1);
    public int count = 0;
    public int count1 = 0;
    public boolean eventCheck;
    public boolean countCheck;
    public KeyEvent keyEvent;
    public int getChainNum() {
        return chainNum;
    }

    public void setChainNum(int chainNum) {
        this.chainNum = chainNum;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public String getConvert() {
        return convert;
    }

    public void setConvert(String convert) {
        this.convert = convert;
    }

    public String getConvert1() {
        return convert1;
    }

    public void setConvert1(String convert1) {
        this.convert1 = convert1;
    }

    public int getConvertINt() {
        return convertINt;
    }
    public void nullCounter(){
        setCount(0);
        setCount1(0);
    }
    public void randomC(){
        setC(randomer());
        setConvert(Integer.toBinaryString(getC()));
    }
    public void setConvertINt(int convertINt) {
        this.convertINt = convertINt;
    }
    public void increaseCount(){
        setCount(getCount() + 1);
    }
    public void increaseCount1(){
        setCount1(getCount1() + 1);
    }
    public boolean eventAction(){
        if(getConvertINt1() >= getConvertINt()){
            eventCheck = true;
        }
        else  if(getConvertINt1() <= getConvertINt()){
            eventCheck = false;
        }
        return  eventCheck;
    }
    public int getConvertINt1() {
        return convertINt1;
    }

    public void setConvertINt1(int convertINt1) {
        this.convertINt1 = convertINt1;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCount1() {
        return count1;
    }

    public void setCount1(int count1) {
        this.count1 = count1;
    }

    public int randomer(){
        int random = (int) ( 5 + Math.random() * 40 );
        return random;
    }
}
