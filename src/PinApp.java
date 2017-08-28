import java.util.Scanner;

/**
 * Created by jedduffey on 8/26/17.
 */
public class PinApp {

    public static final int PIN_LENGTH = 4;
    public static final int MAX_ALLOWED_SQUARE_SIZE = 31; // 31 helps for display purposes
    public static final int MIN_ALLOWED_SQUARE_SIZE = 3; // Because it looks silly if it's 2

    public static void main(String[] args) throws InterruptedException {

        // Initializing the scanner
        Scanner sc = new Scanner(System.in);

        // Welcome message
        printWelcomeMessage();

        // Ask for pad square size
        int squareSize = askSquareSize(sc);

        // Print instructions for key and direction numbers
        printInstructionsForKeyAndDirectionNumbers(squareSize);

        // Ask for key number
        int keyNumber = askKeyNumber(sc);

        // Ask for direction number
        int directionNumber = askDirectionNumber(sc);

        System.out.println();

        printKeyAndDirectionNumbers(keyNumber, directionNumber);

        // Instantiate and setup pinpad
        PinPad pinPad = setupPinPad(squareSize, keyNumber, directionNumber);

        // Create arrays
        int[] guessedSecretNumbers = new int[PIN_LENGTH];
        int[] actualSecretNumbers = new int[PIN_LENGTH];

        for (int whichPadAreWeOn = 0; whichPadAreWeOn < PIN_LENGTH; whichPadAreWeOn++) {

            // Print which PIN/number pad the user is on
            System.out.println("[[ Pad #" + whichPadAreWeOn + " ]]");
            System.out.println();

            pinPad.shuffle(); // Don't forget to shuffle!

            // For each row
            for (int row = 0; row < pinPad.getSquareSize(); row++) {

                // For each element in the row
                for (int rowElement = 0; rowElement < pinPad.getSquareSize(); rowElement++) {

                    int whichElementAreWeOn = rowElement + row * pinPad.getSquareSize();

                    printTheValueInThatPosition(pinPad, whichElementAreWeOn);

                }

                System.out.println();
            }

            System.out.println();

            // Ask user to enter secret number
            int guessedSecretNumber = askForSecretNumber(sc);

            // Add the entered number into the array
            guessedSecretNumbers[whichPadAreWeOn] = guessedSecretNumber;

            // Print the actual secret number (for testing/demo purposes)
            System.out.println("(Correct secret number was " + pinPad.returnSecretNumber() + ")");
            System.out.println();

            // Add the actual secret number into the array
            actualSecretNumbers[whichPadAreWeOn] = pinPad.returnSecretNumber();
        }

        printGuessedSecretNumbers(guessedSecretNumbers);

        printActualSecretNumbers(actualSecretNumbers);

        validateEnteredNumbers(guessedSecretNumbers, actualSecretNumbers);

    }

    private static void printTheValueInThatPosition(PinPad pinPad, int whichElementAreWeOn) {
        if (pinPad.padNumbers.get(whichElementAreWeOn) < 10) {
            System.out.print("  " + pinPad.padNumbers.get(whichElementAreWeOn)); // Hacky way to get numbers to line up for square sizes under 10 (i.e. no numbers larger than two digits).
        } else if (pinPad.padNumbers.get(whichElementAreWeOn) >= 10 && pinPad.padNumbers.get(whichElementAreWeOn) < 100) {
            System.out.print(" " + pinPad.padNumbers.get(whichElementAreWeOn));
        } else {
            System.out.print(pinPad.padNumbers.get(whichElementAreWeOn));
        }
        System.out.print(" ");
    }

    private static int askForSecretNumber(Scanner sc) {
        System.out.print("Enter Secret Number: ");
        return sc.nextInt();
    }

    private static PinPad setupPinPad(int squareSize, int keyNumber, int directionNumber) {
        PinPad pinPad = new PinPad(squareSize);
        pinPad.setKeyNumber(keyNumber);
        pinPad.setDirectionNumber(directionNumber);
        return pinPad;
    }

    private static void printKeyAndDirectionNumbers(int keyNumber, int directionNumber) {
        System.out.println("Key number is " + keyNumber);
        System.out.println("Direction number is " + directionNumber);
        System.out.println();
    }

    private static int askDirectionNumber(Scanner sc) {
        System.out.print("Enter direction number: ");
        return sc.nextInt();
    }

    private static int askKeyNumber(Scanner sc) {
        System.out.print("Enter key number: ");
        return sc.nextInt();
    }

    private static void printInstructionsForKeyAndDirectionNumbers(int squareSize) {
        System.out.println("SQUARE SIZE: " + squareSize);
        System.out.println("Key and direction numbers must be between");
        System.out.println("0 and " + (squareSize * squareSize - 1));
        System.out.println();
    }

    private static int askSquareSize(Scanner sc) {
        System.out.println("Enter pad size.");
        System.out.println("Must be between " + MIN_ALLOWED_SQUARE_SIZE + " and " +  MAX_ALLOWED_SQUARE_SIZE + " (inclusive): ");
        int squareSize = sc.nextInt(); // Why does only the first input stick??
        System.out.println("You entered: " + squareSize);
        if(squareSize > MAX_ALLOWED_SQUARE_SIZE){
            System.out.println("<!> Square size must be less than or equal to " + MAX_ALLOWED_SQUARE_SIZE + " <!>");
            System.out.println();
            askSquareSize(sc);
        }
        if(squareSize < MIN_ALLOWED_SQUARE_SIZE){
            System.out.println("<!> Square size must be greater than or equal to " + MIN_ALLOWED_SQUARE_SIZE + " <!>");
            System.out.println();
            askSquareSize(sc);
        }
        System.out.println();
        return squareSize;
    }

    private static void printWelcomeMessage() {
        System.out.println();
        System.out.println("*****************************");
        System.out.println("**  WELCOME TO THE PINPAD  **");
        System.out.println("*****************************");
        System.out.println();
    }

    private static void printGuessedSecretNumbers(int[] guessedSecretNumbers) {
        for (int i = 0; i < PIN_LENGTH; i++) {
            System.out.print(guessedSecretNumbers[i] + " ");
        }

        System.out.print("<-- Guessed secret numbers");

        System.out.println();
    }

    private static void printActualSecretNumbers(int[] actualSecretNumbers) {
        for (int i = 0; i < PIN_LENGTH; i++) {
            System.out.print(actualSecretNumbers[i] + " ");
        }

        System.out.print("<-- Actual secret numbers");

        System.out.println();
    }

    private static void validateEnteredNumbers(int[] guessedSecretNumbers, int[] actualSecretNumbers) {
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
