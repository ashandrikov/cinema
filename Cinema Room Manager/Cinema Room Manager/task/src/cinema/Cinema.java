package cinema;

import cinema.models.SeatCell;

import java.util.ArrayList;
import java.util.List;

import static cinema.utils.InputValidator.validateBookingInput;
import static cinema.utils.InputValidator.validateInputGeneral;
import static cinema.utils.InputValidator.validateInputMenu;
import static cinema.utils.InputValidator.validateSizeHall;
import static cinema.utils.StringPool.BOOK_ROW;
import static cinema.utils.StringPool.BOOK_SEAT;
import static cinema.utils.StringPool.CINEMA;
import static cinema.utils.StringPool.MENU_0;
import static cinema.utils.StringPool.MENU_1;
import static cinema.utils.StringPool.MENU_2;
import static cinema.utils.StringPool.MENU_3;
import static cinema.utils.StringPool.STATS_COUNT;
import static cinema.utils.StringPool.STATS_CURRENT_INCOME;
import static cinema.utils.StringPool.STATS_PERCENTAGE;
import static cinema.utils.StringPool.STATS_TOTAL_INCOME;
import static cinema.utils.StringPool.TICKET_PRICE;
import static cinema.utils.StringPool.TOTAL_ROWS;
import static cinema.utils.StringPool.TOTAL_SEATS;
import static cinema.utils.StringPool.WRONG_INPUT;
import static cinema.utils.StringPool.WRONG_INPUT_MENU;
import static cinema.utils.StringPool.WRONG_INPUT_PURCHASED;

public class Cinema {

    private static int rows;
    private static int seats;
    private static SeatCell[][] hall;
    private static boolean isSmallRoom;
    private static int chosenRow;
    private static int chosenSeat;
    private static int numberPurchasedTickets;
    private static double percentage;
    private static int currentIncome;
    private static int totalIncome;

    private List <SeatCell> seatCells;

    public static void main(String[] args) {
        Cinema myCinema = new Cinema();
        myCinema.createCinema();
        while (true) {
            if (!myCinema.invitation()) {
                break;
            }
        }
    }

    private void createCinema() {
        knowRowsSeatsCount();
        countTotalIncome();
        createSeatCells();
    }


    private void knowRowsSeatsCount() {
        while (true){
            System.out.print(TOTAL_ROWS);
            rows = validateSizeHall();
            System.out.print(TOTAL_SEATS);
            seats = validateSizeHall();
            if (rows != -1 && seats != -1){
                break;
            }
            System.out.println(WRONG_INPUT);
        }
        System.out.println();
    }

    private void countTotalIncome() {
        if (rows * seats <= 60) {
            totalIncome = rows * seats * 10;
            isSmallRoom = true;
        } else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            totalIncome = firstHalf * seats * 10 + secondHalf * seats * 8;
            isSmallRoom = false;
        }
    }

    private void createSeatCells() {
        SeatCell cell;
        seatCells = new ArrayList<>();
        hall = new SeatCell[rows][seats];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seats; j++) {
                cell = new SeatCell();
                cell.setEmpty(true);
                hall[i-1][j-1] = cell;
            }
        }
    }

    private boolean invitation() {
        System.out.println(MENU_1);
        System.out.println(MENU_2);
        System.out.println(MENU_3);
        System.out.println(MENU_0);
        int userInput = validateInputMenu();

        switch (userInput) {
            case 1 -> printAll();
            case 2 -> printBookInfo();
            case 3 -> showStatistic();
            case 0 -> {
                return false;
            }
            default -> {
                System.out.println(WRONG_INPUT_MENU);
            }
        }
        return true;
    }


    private void printAll() {
        printHeader();
        printFirstLine();
        printHall();
    }

    private void printHeader() {
        System.out.println(CINEMA);
    }

    private void printFirstLine() {
        System.out.print("  ");
        for (int i = 1; i <= seats; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private void printHall() {
        for (int i = 1; i <= rows; i++) {
            System.out.print(i + " ");
            for (int j = 1; j <= seats; j++) {
                if (hall[i-1][j-1].isEmpty()) {
                    System.out.print("S ");
                } else {
                    System.out.print("B ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private void printBookInfo() {
        while (true) {
            chosenRow = 0;
            chosenSeat = 0;
            System.out.print(BOOK_ROW);
            chosenRow = validateBookingInput(rows);
            System.out.print(BOOK_SEAT);
            chosenSeat = validateBookingInput(seats);
            if (chosenRow == -1 || chosenSeat == -1){
                System.out.println(WRONG_INPUT);
                continue;
            }
            if (!hall[chosenRow-1][chosenSeat-1].isEmpty()) {
                System.out.println(WRONG_INPUT_PURCHASED);
                continue;
            }
            break;
        }
        showTicketPrice();
        bookPlace();
    }

    private void showTicketPrice() {
        int price = isSmallRoom ? 10 : chosenRow <= rows / 2 ? 10 : 8;
        System.out.printf(TICKET_PRICE, price);
        currentIncome += price;
        System.out.println();
    }

    private void bookPlace() {
        hall[chosenRow - 1][chosenSeat - 1].setEmpty(false);
        numberPurchasedTickets++;
        percentage = numberPurchasedTickets == 0
                ? 0
                : (double) numberPurchasedTickets * 100 / (rows * seats);
        System.out.println();
        printAll();
    }

    private void showStatistic() {
        System.out.printf(STATS_COUNT, numberPurchasedTickets);
        System.out.println();
        System.out.printf(STATS_PERCENTAGE, percentage);
        System.out.println();
        System.out.printf(STATS_CURRENT_INCOME, currentIncome);
        System.out.println();
        System.out.printf(STATS_TOTAL_INCOME, totalIncome);
        System.out.println();
        System.out.println();
    }

}