import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by jedduffey on 8/9/17.
 */
public class PinPad {

    private final int squareSize;

    private int keyNumber;
    private int directionNumber;

    ArrayList<Integer> padNumbers;

    public PinPad(int squareSize) {

        this.squareSize = squareSize;

        padNumbers = new ArrayList<Integer>();

        fillArrayWithValues(squareSize);
    }

    private void fillArrayWithValues(int squareSize) {
        for (int i = 0; i <
                (squareSize * squareSize); i++) {
            padNumbers.add(i);
        }
    }

    public int returnSecretNumber() {

        int indexOfInterimSecretNumber = moveVertical(padNumbers.indexOf(getKeyNumber()));
        indexOfInterimSecretNumber = moveHorizontal(indexOfInterimSecretNumber);

        return padNumbers.get(indexOfInterimSecretNumber);

    }

    private int moveHorizontal(int indexOfInterimSecretNumber) {

        if (returnHorizontalDisplacementFactor() > 0) {
            indexOfInterimSecretNumber = indexOfInterimSecretNumber
                    + returnHorizontalDisplacementFactor()
                    - squareSize
                    * ((indexOfInterimSecretNumber
                    % squareSize + returnHorizontalDisplacementFactor()) / squareSize);
        }
        if (returnHorizontalDisplacementFactor() < 0) {
            indexOfInterimSecretNumber = indexOfInterimSecretNumber
                    + returnHorizontalDisplacementFactor()
                    + squareSize
                    * ((((indexOfInterimSecretNumber + (returnHorizontalDisplacementFactor() + squareSize))
                    % squareSize + Math.abs(returnHorizontalDisplacementFactor())) / squareSize));
        }
        return indexOfInterimSecretNumber;
    }

    private int moveVertical(int indexOfInterimSecretNumber) {
        if (returnVerticalDisplacementFactor() != 0) {
            // The sign before the Integer.signum() method is what determines the orientation of the y-axis.
            indexOfInterimSecretNumber = Math.floorMod(indexOfInterimSecretNumber
                    - Integer.signum(returnVerticalDisplacementFactor())
                    * squareSize, padNumbers.size());
        }
        return indexOfInterimSecretNumber;
    }

    public int returnHorizontalDisplacementFactor() { // Involves columns.

        int horizontalDisplacementFactor;

        // Like an x-y graph, right is positive and left is negative.
        int columnNumberIfLeftColumnDefinedAsRowZero = padNumbers.indexOf(directionNumber) % squareSize;
        int centerlineValue = squareSize / 2;
        if (squareSize % 2 == 0 && columnNumberIfLeftColumnDefinedAsRowZero >= centerlineValue) {
            horizontalDisplacementFactor = columnNumberIfLeftColumnDefinedAsRowZero - centerlineValue + 1;
        } else {
            horizontalDisplacementFactor = columnNumberIfLeftColumnDefinedAsRowZero - centerlineValue;
        }
        return horizontalDisplacementFactor;

    }

    public int returnVerticalDisplacementFactor() { // Involves rows.

        int verticalDisplacementFactor;

        // Like an x-y graph, up is positive and down is negative.
        int rowNumberIfBottomRowDefinedAsRowZero = ((squareSize * squareSize - 1) - padNumbers.indexOf(directionNumber)) / squareSize;
        int centerlineValue = squareSize / 2;
        if (squareSize % 2 == 0 && rowNumberIfBottomRowDefinedAsRowZero >= centerlineValue){
            verticalDisplacementFactor = rowNumberIfBottomRowDefinedAsRowZero - centerlineValue + 1;
        }else{
        verticalDisplacementFactor = rowNumberIfBottomRowDefinedAsRowZero - centerlineValue;}

        return verticalDisplacementFactor;

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

    // Created a method for this in case I want to change later how the shuffling/randomizing is implemented.
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

    public void setNumbers16(int i0, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15) {
        padNumbers.set(0, i0);
        padNumbers.set(1, i1);
        padNumbers.set(2, i2);
        padNumbers.set(3, i3);
        padNumbers.set(4, i4);
        padNumbers.set(5, i5);
        padNumbers.set(6, i6);
        padNumbers.set(7, i7);
        padNumbers.set(8, i8);
        padNumbers.set(9, i9);
        padNumbers.set(10, i10);
        padNumbers.set(11, i11);
        padNumbers.set(12, i12);
        padNumbers.set(13, i13);
        padNumbers.set(14, i14);
        padNumbers.set(15, i15);
    }
}
