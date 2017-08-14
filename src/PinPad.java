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

        int indexOfDirectionNumber = padNumbers.indexOf(getDirectionNumber());
        int indexOfInterimKeyNumber = padNumbers.indexOf(getKeyNumber());

        boolean isInTopRow = indexOfDirectionNumber >= 0 && indexOfDirectionNumber <= 2;
        boolean isInBottomRow = indexOfDirectionNumber >= 6 && indexOfDirectionNumber <= 8;
        boolean isInLeftColumn = indexOfDirectionNumber == 0 || indexOfDirectionNumber == 3 || indexOfDirectionNumber == 6;
        boolean isInRightColumn = indexOfDirectionNumber == 2 || indexOfDirectionNumber == 5 || indexOfDirectionNumber == 8;

        if(isInTopRow){
            indexOfInterimKeyNumber = moveIndexUp(indexOfInterimKeyNumber);
        }
        if(isInBottomRow){
            indexOfInterimKeyNumber = moveIndexDown(indexOfInterimKeyNumber);
        }
        if(isInLeftColumn){
            indexOfInterimKeyNumber = moveIndexLeft(indexOfInterimKeyNumber);
        }
        if(isInRightColumn){
            indexOfInterimKeyNumber = moveIndexRight(indexOfInterimKeyNumber);
        }

        return padNumbers.get(indexOfInterimKeyNumber);

    }

    private int moveIndexLeft(int indexOfKeyNumber) {
        int indexOfSecretNumber;
        if (indexOfKeyNumber == TOP_LEFT_INDEX || indexOfKeyNumber == MIDDLE_LEFT_INDEX || indexOfKeyNumber == BOTTOM_LEFT_INDEX) {
            indexOfSecretNumber = indexOfKeyNumber + 2;
        } else indexOfSecretNumber = indexOfKeyNumber - 1;
        return indexOfSecretNumber;
    }

    private int moveIndexRight(int indexOfKeyNumber) {
        int indexOfSecretNumber;
        if (indexOfKeyNumber == TOP_RIGHT_INDEX || indexOfKeyNumber == MIDDLE_RIGHT_INDEX || indexOfKeyNumber == BOTTOM_RIGHT_INDEX) {
            indexOfSecretNumber = indexOfKeyNumber - 2;
        } else indexOfSecretNumber = indexOfKeyNumber + 1;
        return indexOfSecretNumber;
    }

    private int moveIndexDown(int indexOfKeyNumber) {
        int indexOfSecretNumber;
        indexOfSecretNumber = Math.floorMod(indexOfKeyNumber + PAD_DIRECTION_DOWN_ONE_ROW, padNumbers.size());
        return indexOfSecretNumber;
    }

    private int moveIndexUp(int indexOfKeyNumber) {
        int indexOfSecretNumber;
        indexOfSecretNumber = Math.floorMod(indexOfKeyNumber + PAD_DIRECTION_UP_ONE_ROW, padNumbers.size());
        return indexOfSecretNumber;
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
