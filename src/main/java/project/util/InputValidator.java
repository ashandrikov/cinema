package project.util;

import java.util.InputMismatchException;
import java.util.Scanner;

import static project.util.StringPool.WRONG_INPUT;

public class InputValidator {

    private InputValidator() {
        throw new IllegalStateException("Utility class");
    }

    public static int validateInputGeneral(){
        int result;
        Scanner scanner = new Scanner(System.in);
        try{
            result = Integer.parseInt(String.valueOf(scanner.nextInt()));
        } catch (NumberFormatException | InputMismatchException e) {
            return -1;
        }
        return result;
    }

    public static int validateSizeHall(){
        int result = validateInputGeneral();
        if (result < 1 || result > 15) {
            return -1;
        }
        return result;
    }

    public static int validateInputMenu(){
        int result = validateInputGeneral();
        if (result < 0 || result > 3) {
            System.out.println(WRONG_INPUT);
            return -1;
        }
        return result;
    }

    public static int validateBookingInput(int rowsOrSeats){
        int result = validateInputGeneral();
        if (result < 1 || result > rowsOrSeats) {
            return -1;
        }
        return result;
    }

}
