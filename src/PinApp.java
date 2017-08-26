import java.util.Scanner;

/**
 * Created by jedduffey on 8/26/17.
 */
public class PinApp {

    public static final int PIN_LENGTH = 4;

    public static void main(String[] args) {

        // Initializing the scanner
        Scanner sc = new Scanner(System.in);

        // Welcome message
        System.out.println();
        System.out.println("*****************************");
        System.out.println("**  WELCOME TO THE PINPAD  **");
        System.out.println("*****************************");
        System.out.println();
        /*System.out.println("Enter your name: ");
        String name = sc.nextLine();*/

        System.out.print("Enter pad size (less than 32): ");
        int squareSize = sc.nextInt();
        System.out.println();

        System.out.println("Key and direction numbers must be between");
        System.out.println("0 and the square of the pad size.");
        System.out.println();
        System.out.print("Enter key number: ");
        int keyNumber = sc.nextInt();
        System.out.print("Enter direction number: ");
        int directionNumber = sc.nextInt();
        System.out.println();

        System.out.println("Key number is " + keyNumber);
        System.out.println("Direction number is " + directionNumber);
        System.out.println();

        PinPad pinPad = new PinPad(squareSize);

        pinPad.setKeyNumber(keyNumber);
        pinPad.setDirectionNumber(directionNumber);

        int[] guessedSecretNumbers = new int[4];
        int[] actualSecretNumbers = new int[4];

        for (int whichPadAreWeOn = 1; whichPadAreWeOn <= PIN_LENGTH; whichPadAreWeOn++) {

            System.out.println("[[ Pad #" + whichPadAreWeOn + " ]]");
            System.out.println();

            pinPad.shuffle(); // Don't forget to shuffle!

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

                System.out.println();
            }

            System.out.println();
            System.out.print("Enter Secret Number: ");
            int guessedSecretNumber = sc.nextInt();

            guessedSecretNumbers[whichPadAreWeOn - 1] = guessedSecretNumber;

            System.out.println("(Correct secret number was: " + pinPad.returnSecretNumber() + ")");
            System.out.println();

            actualSecretNumbers[whichPadAreWeOn - 1] = pinPad.returnSecretNumber();
        }

        for (int i = 0; i < PIN_LENGTH; i++) {
            System.out.print(guessedSecretNumbers[i] + " ");
        }

        System.out.print("<-- Guessed secret numbers");

        System.out.println();

        for (int i = 0; i < PIN_LENGTH; i++) {
            System.out.print(actualSecretNumbers[i] + " ");
        }

        System.out.print("<-- Actual secret numbers");

        System.out.println();

        boolean accessGranted = false;

        for (int i = 0; i < PIN_LENGTH; i++) {

            if (guessedSecretNumbers[i] != actualSecretNumbers[i]) {
                accessGranted = false;
                break;
            } else accessGranted = true;

        }

        System.out.println();

        if (accessGranted) {
            System.out.println("ACCESS GRANTED");
        } else System.out.println("INCORRECT PIN - ACCESS DENIED");

    }
}
