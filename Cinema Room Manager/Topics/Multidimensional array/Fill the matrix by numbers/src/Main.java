import java.util.Scanner;

class Main {
    private static int input;
    private static int[][] array;

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
        array = new int[input][input];
        for (int i = 0; i < input; i++) {
            for (int j = 0; j < input; j++) {
                array[i][j] = Math.abs(i - j);
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