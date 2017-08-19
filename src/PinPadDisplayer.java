/**
 * Created by jedduffey on 8/19/17.
 */
public class PinPadDisplayer {

    public static final int HOW_MANY_PADS_TO_DISPLAY = 3;

    public static void main(String[] args){

        for(int i = 0; i < HOW_MANY_PADS_TO_DISPLAY; i++){

            PinPad pinPad = new PinPad(9);
            pinPad.shuffle();

            for(int row = 0; row < pinPad.getSquareSize(); row++){

                for(int rowElement = 0; rowElement < pinPad.getSquareSize(); rowElement++) {

                    int whichElementAreWeOn = rowElement + row*pinPad.getSquareSize();
                    if(pinPad.padNumbers.get(whichElementAreWeOn)<10){
                        System.out.print(" "); // Hacky way to get numbers to line up for square sizes under 10 (i.e. no numbers larger than two digits).
                    }
                    System.out.print(pinPad.padNumbers.get(whichElementAreWeOn) + " ");

                }
                System.out.println(); // Print a newline between rows.
            }

            System.out.println(); // Print a newline between pads.
        }

    }

}
