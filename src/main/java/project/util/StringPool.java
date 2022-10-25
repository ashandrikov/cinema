package project.util;

import static project.util.TextColor.RED;
import static project.util.TextColor.RESET;

public class StringPool {
    public static final String MENU_1 = "1. Show the seats";
    public static final String MENU_2 = "2. Buy a ticket";
    public static final String MENU_3 = "3. Statistics";
    public static final String MENU_0 = RED + "0. Exit" + RESET;
    public static final String CINEMA = "Cinema:";
    public static final String BOOK_ROW = "Enter a row number:\n";
    public static final String BOOK_SEAT = "Enter a seat number in that row:\n";
    public static final String WRONG_INPUT = "Wrong input!";
    public static final String WRONG_INPUT_PURCHASED = "That ticket has already been purchased!";
    public static final String TICKET_PRICE = "Ticket price: $%d\n";
    public static final String STATS_COUNT = "Number of purchased tickets: %d\n";
    public static final String STATS_PERCENTAGE = "Percentage: %.2f%%\n";
    public static final String STATS_CURRENT_INCOME = "Current income: $%d\n";
    public static final String STATS_TOTAL_INCOME = "Total income: $%d\n\n";
    public static final String TOTAL_ROWS = "Enter the number of rows: (1-15)\n";
    public static final String TOTAL_SEATS = "Enter the number of seats in each row: (1-15)\n";
    public static final String WRONG_INPUT_MENU = "You should choose 0-3\n";

    private StringPool() {
        throw new IllegalStateException("Utility class");
    }
}
