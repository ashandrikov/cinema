import java.util.Scanner;

class Main {
    private static int input;
    private static String[][] array;

    public static void main(String[] args) {
        input = readInput();
        fillArray();
        printMatrix();
    }

    private static int readInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static void fillArray() {
        array = new String[input][input];
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                if (i == j || input / 2 == i || input / 2 == j) {
                    array[i][j] = "*";
                } else if (i + j == input - 1) {
                    array[i][input - i - 1] = "*";
                } else {
                    array[i][j] = ".";
                }
            }
        }
    }

    private static void printMatrix() {
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}