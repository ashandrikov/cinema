package project.controller;

import project.model.SeatCell;

import static project.util.InputValidator.validateBookingInput;
import static project.util.InputValidator.validateInputMenu;
import static project.util.InputValidator.validateSizeHall;
import static project.util.Printer.printAll;
import static project.util.StringPool.BOOK_ROW;
import static project.util.StringPool.BOOK_SEAT;
import static project.util.StringPool.MENU_0;
import static project.util.StringPool.MENU_1;
import static project.util.StringPool.MENU_2;
import static project.util.StringPool.MENU_3;
import static project.util.StringPool.STATS_COUNT;
import static project.util.StringPool.STATS_CURRENT_INCOME;
import static project.util.StringPool.STATS_PERCENTAGE;
import static project.util.StringPool.STATS_TOTAL_INCOME;
import static project.util.StringPool.TICKET_PRICE;
import static project.util.StringPool.TOTAL_ROWS;
import static project.util.StringPool.TOTAL_SEATS;
import static project.util.StringPool.WRONG_INPUT;
import static project.util.StringPool.WRONG_INPUT_MENU;
import static project.util.StringPool.WRONG_INPUT_PURCHASED;

public class CinemaController extends Thread{

    private int rows;
    private int seats;
    private SeatCell[][] hall;
    private boolean isSmallRoom;
    private int chosenRow;
    private int chosenSeat;

    private int numberPurchasedTickets;
    private double percentage;
    private int currentIncome;
    private int totalIncome;

    @Override
    public void run() {
        CinemaController myCinema = new CinemaController();
        myCinema.createCinema();
        while (true) {
            if (!myCinema.booking()) {
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
        hall = new SeatCell[rows][seats];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= seats; j++) {
                cell = new SeatCell();
                cell.setEmpty(true);
                hall[i-1][j-1] = cell;
            }
        }
    }

    private boolean booking() {
        System.out.println(MENU_1);
        System.out.println(MENU_2);
        System.out.println(MENU_3);
        System.out.println(MENU_0);
        int userInput = validateInputMenu();

        switch (userInput) {
            case 1 -> printAll(rows, seats, hall);
            case 2 -> printBookInfo();
            case 3 -> showStatistic();
            case 0 -> {
                return false;
            }
            default -> System.out.println(WRONG_INPUT_MENU);
        }
        return true;
    }

    private void printBookInfo() {
        while (true) {
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
        int price;
        if (isSmallRoom) {
            price = 10;
        } else {
            if (chosenRow <= rows / 2) price = 10;
            else price = 8;
        }
        currentIncome += price;
        System.out.printf(TICKET_PRICE, price);
    }

    private void bookPlace() {
        hall[chosenRow - 1][chosenSeat - 1].setEmpty(false);
        numberPurchasedTickets++;
        percentage = numberPurchasedTickets == 0
                ? 0
                : (double) numberPurchasedTickets * 100 / (rows * seats);
        System.out.println();
        printAll(rows, seats, hall);
    }

    private void showStatistic() {
        System.out.printf(STATS_COUNT, numberPurchasedTickets);
        System.out.printf(STATS_PERCENTAGE, percentage);
        System.out.printf(STATS_CURRENT_INCOME, currentIncome);
        System.out.printf(STATS_TOTAL_INCOME, totalIncome);
    }
}
