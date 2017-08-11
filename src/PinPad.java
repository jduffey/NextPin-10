import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    public static final int HOW_MANY_NUMBERS_ON_THE_PINPAD = 9;
    private int keyNumber;
    private int directionNumber;

    ArrayList<Integer> padNumbers;

    public PinPad() {

        padNumbers = new ArrayList<Integer>();

        for (int i = 0; i <
                HOW_MANY_NUMBERS_ON_THE_PINPAD; i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int secretNumber = 1;

        return secretNumber;

    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }

    public void setKeyNumber(int keyNumber) {
        this.keyNumber = keyNumber;
    }

    public void setDirectionNumber(int directionNumber) {
        this.directionNumber = directionNumber;
    }

    public void shuffle() {
        Collections.shuffle(padNumbers);
    }

    public void setNumbers(Integer topLeft, Integer topCenter, Integer topRight, Integer middleLeft, Integer middleCenter, Integer middleRight
            , Integer bottomLeft, Integer bottomCenter, Integer bottomRight) {
        padNumbers.set(0, topLeft);
        padNumbers.set(1, topCenter);
        padNumbers.set(2, topRight);
        padNumbers.set(3, middleLeft);
        padNumbers.set(4, middleCenter);
        padNumbers.set(5, middleRight);
        padNumbers.set(6, bottomLeft);
        padNumbers.set(7, bottomCenter);
        padNumbers.set(8, bottomRight);
    }

    public int returnTopLeft() {
        return padNumbers.indexOf(0);
    }

    public int returnTopCenter() {
        return padNumbers.indexOf(1);
    }

    public int returnTopRight() {
        return padNumbers.indexOf(2);
    }

    public int returnMiddleLeft() {
        return padNumbers.indexOf(3);
    }

    public int returnMiddleCenter() {
        return padNumbers.indexOf(4);
    }

    public int returnMiddleRight() {
        return padNumbers.indexOf(5);
    }

    public int returnBottomLeft() {
        return padNumbers.indexOf(6);
    }

    public int returnBottomCenter() {
        return padNumbers.indexOf(7);
    }

    public int returnBottomRight() {
        return padNumbers.indexOf(8);
    }
}
