import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    public static final int HOW_MANY_NUMBERS_ON_THE_PINPAD = 9;
    public static final int TOP_LEFT_INDEX = 0;
    public static final int TOP_CENTER_INDEX = 1;
    public static final int TOP_RIGHT_INDEX = 2;
    public static final int MIDDLE_LEFT_INDEX = 3;
    public static final int MIDDLE_CENTER_INDEX = 4;
    public static final int MIDDLE_RIGHT_INDEX = 5;
    public static final int BOTTOM_LEFT_INDEX = 6;
    public static final int BOTTOM_CENTER_INDEX = 7;
    public static final int BOTTOM_RIGHT_INDEX = 8;
    public static final int PAD_DIRECTION_UP_ONE_ROW = -3;
    public static final int PAD_DIRECTION_DOWN_ONE_ROW = 3;
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

        int secretNumber = -99;

        int indexOfDirectionNumber = padNumbers.indexOf(getDirectionNumber());
        int indexOfKeyNumber = padNumbers.indexOf(getKeyNumber());
        int indexOfSecretNumber;

        switch (indexOfDirectionNumber) {
            case TOP_CENTER_INDEX: //indexOfKeyNumber = padNumbers.indexOf(getKeyNumber());
                indexOfSecretNumber = Math.floorMod(indexOfKeyNumber + PAD_DIRECTION_UP_ONE_ROW, padNumbers.size());
                secretNumber = padNumbers.get(indexOfSecretNumber);
                break;
            case BOTTOM_CENTER_INDEX:
                //indexOfKeyNumber = padNumbers.indexOf(getKeyNumber());
                indexOfSecretNumber = Math.floorMod(indexOfKeyNumber + PAD_DIRECTION_DOWN_ONE_ROW, padNumbers.size());
                secretNumber = padNumbers.get(indexOfSecretNumber);
                break;
            case MIDDLE_CENTER_INDEX:
                secretNumber = getKeyNumber();
                break;
        }

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

    public int returnNumber(int positionOfNumberToReturn) {
        return padNumbers.indexOf(positionOfNumberToReturn);
    }

}
