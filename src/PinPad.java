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

    public void setNumbers(Integer i0, Integer i1, Integer i2, Integer i3, Integer i4, Integer i5, Integer i6, Integer i7, Integer i8) {
        padNumbers.set(0, i0);
        padNumbers.set(1, i1);
        padNumbers.set(2, i2);
        padNumbers.set(3, i3);
        padNumbers.set(4, i4);
        padNumbers.set(5, i5);
        padNumbers.set(6, i6);
        padNumbers.set(7, i7);
        padNumbers.set(8, i8);
    }
}
