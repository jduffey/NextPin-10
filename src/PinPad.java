import java.util.ArrayList;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    ArrayList<Integer> padNumbers;

    public PinPad() {
        padNumbers = new ArrayList<Integer>();
        padNumbers.add(0);
        padNumbers.add(1);
        padNumbers.add(2);
        padNumbers.add(3);
        padNumbers.add(4);
        padNumbers.add(5);
        padNumbers.add(6);
        padNumbers.add(7);
        padNumbers.add(8);
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
