package model;

public class GameLogic {
    public int a = randomer();
    public int b = randomer();
    public String convert = Integer.toBinaryString(a);
    public String convert1 = Integer.toBinaryString(b);
    public int convertINt = Integer.parseInt(convert);
    public int convertINt1 = Integer.parseInt(convert1);

    public String getConvert() {
        return convert;
    }

    public void setConvert(String convert) {
        this.convert = convert;
    }

    public void setConvertINt(int convertINt) {
        this.convertINt = convertINt;
    }

    public String getConvert1() {
        return convert1;
    }

    public int getConvertINt() {
        return convertINt;
    }

    public int getConvertINt1() {
        return convertINt1;
    }

    public void setConvertINt1(int convertINt1) {
        this.convertINt1 = convertINt1;
    }

    public boolean check(){
        return (getConvertINt1() > getConvertINt()) ;
    }

    public int randomer(){
        int random = (int) ( 5 + Math.random() * 40 );
        return random;
    }
}
