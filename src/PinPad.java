import java.util.ArrayList;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    ArrayList<Integer> padNumbers;

    public PinPad() {

        padNumbers = new ArrayList<Integer>();

        for (int i = 0; i < 9; i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int secretNumber = -1;

        return secretNumber;

    }

    public Integer getKeyNumber() {
        return 1;
    }

    public Integer getDirectionNumber() {
        return 1;
    }
}
