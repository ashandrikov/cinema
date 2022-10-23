package cinema;

import java.util.Scanner;

public class Cinema {

    private static int rows;
    private static int seats;
    private static String[][] array;
    private static boolean isSmallRoom;
    private static int chosenRow;
    private static int chosenSeat;

    public static void main(String[] args) {
        readInput();
        showIncome();
        fillArray();
        while (true) {
            invitation();
        }
//        printAll();
//        printBookInfo();
//        showTicketPrice();
//        bookPlace();
    }


    private static void readInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows:\n");
        rows = scanner.nextInt();
        System.out.print("Enter the number of seats in each row:\n");
        seats = scanner.nextInt();
        System.out.println();
    }

    private static void showIncome() {
        int result;
        if (rows * seats <= 60) {
            result = rows * seats * 10;
            isSmallRoom = true;
        } else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            result = firstHalf * seats * 10 + secondHalf * seats * 8;
            isSmallRoom = false;
        }
//        System.out.println("Total income:\n$" + result);
    }

    private static void invitation() {
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("0. Exit");
        Scanner scanner = new Scanner(System.in);
        int userInput = scanner.nextInt();
        System.out.println();

        switch (userInput) {
            case 1 -> printAll();
            case 2 -> printBookInfo();
            case 0 -> System.exit(500);
            default -> throw new IllegalArgumentException();
        }
    }

    private static void printAll() {
        printHeader();
        printFirstLine();
        printArray();
    }

    private static void printHeader() {
        System.out.println("Cinema:");
    }

    private static void printFirstLine() {
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void fillArray() {
        array = new String[rows][seats];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < seats; j++) {
                array[i][j] = "S";
            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < rows; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < seats; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void printBookInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a row number:\n");
        chosenRow = scanner.nextInt();
        System.out.print("Enter a seat number in that row:\n");
        chosenSeat = scanner.nextInt();
        showTicketPrice();
        bookPlace();
    }

    private static void showTicketPrice() {
        int price = isSmallRoom ? 10 : chosenRow <= rows / 2 ? 10 : 8;
        System.out.printf("Ticket price: $%d", price);
        System.out.println();
    }

    private static void bookPlace() {
        array[chosenRow - 1][chosenSeat - 1] = "B";
        System.out.println();
        printAll();
    }

}