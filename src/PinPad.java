import java.util.ArrayList;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    public static final int HOW_MANY_NUMBERS_ON_THE_PINPAD = 9;
    private final int keyNumber;
    private final int directionNumber;

    ArrayList<Integer> padNumbers;

    public PinPad(int keyNumber, int directionNumber) {

        this.keyNumber = keyNumber;
        this.directionNumber = directionNumber;

        padNumbers = new ArrayList<Integer>();

        for (int i = 0; i <
                HOW_MANY_NUMBERS_ON_THE_PINPAD; i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int secretNumber = -1;

        return secretNumber;

    }

    public int getKeyNumber() {
        return keyNumber;
    }

    public int getDirectionNumber() {
        return directionNumber;
    }
}
