/**
 * Created by jedduffey on 8/19/17.
 */
public class PinPadDisplayer {

    public static final int HOW_MANY_PADS_TO_DISPLAY = 10;

    public static void main(String[] args) {

        for (int i = 0; i < HOW_MANY_PADS_TO_DISPLAY; i++) {

            PinPad pinPad = new PinPad(12);
            pinPad.setKeyNumber(1);
            pinPad.setDirectionNumber(5);
            pinPad.shuffle();

            for (int row = 0; row < pinPad.getSquareSize(); row++) {

                for (int rowElement = 0; rowElement < pinPad.getSquareSize(); rowElement++) {

                    int whichElementAreWeOn = rowElement + row * pinPad.getSquareSize();

                    if (pinPad.padNumbers.get(whichElementAreWeOn) < 10) {
                        System.out.print("  " + pinPad.padNumbers.get(whichElementAreWeOn)); // Hacky way to get numbers to line up for square sizes under 10 (i.e. no numbers larger than two digits).
                    } else if (pinPad.padNumbers.get(whichElementAreWeOn) >= 10 && pinPad.padNumbers.get(whichElementAreWeOn) < 100) {
                        System.out.print(" " + pinPad.padNumbers.get(whichElementAreWeOn));
                    } else {
                        System.out.print(pinPad.padNumbers.get(whichElementAreWeOn));
                    }
                    System.out.print(" ");

                }
                System.out.println(); // Print a newline between rows.
            }

            System.out.println("Key number: " + pinPad.getKeyNumber());
            System.out.println("Direction number: " + pinPad.getDirectionNumber());
            System.out.println("Horizontal displacement: " + pinPad.returnHorizontalDisplacementFactor());
            System.out.println("Vertical displacement: " + pinPad.returnVerticalDisplacementFactor());
            System.out.println("Secret number: " + pinPad.returnSecretNumber());
            System.out.println(); // Print a newline between pads.
        }

    }

}
