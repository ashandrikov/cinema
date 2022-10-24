package cinema.utils;

import cinema.models.SeatCell;

import static cinema.utils.StringPool.CINEMA;
import static cinema.utils.TextColor.GREEN;
import static cinema.utils.TextColor.PURPLE;
import static cinema.utils.TextColor.RESET;

public class Printer {
    public static void printAll(int rows, int seats, SeatCell[][] hall) {
        printFirstLine(seats);
        printHall(rows, seats, hall);
    }

    private static void printFirstLine(int seats) {
        System.out.println(CINEMA);
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void printHall(int rows, int seats, SeatCell[][] hall) {
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seats; j++) {
                if (hall[i-1][j-1].isEmpty()) {
                    System.out.print(GREEN + "S " + RESET);
                } else {
                    System.out.print(PURPLE + "B " + RESET);
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
