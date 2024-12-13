import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Scanner;

public class CinemaHall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int rows, cols, options;
        String seatCode;
        String[] multiSeatsCode;
        String[] seats;
        char c = 'A';
        System.out.println("Enter the number of Seats");
        System.out.print("[+] Insert row: ");
        rows = input.nextInt();
        System.out.print("[+] Insert column: ");
        cols = input.nextInt();
        String[][] hall = new String[rows][cols];
        String[][] bookingHistory = new String[rows * cols][2];
        int bookingCount = 0;
        for (int i = 0; i < rows; i++) {
            System.out.print("[");
            for (int j = 0; j < cols; j++) {
                hall[i][j] = c + "-" + (j + 1) + ": " + "AV";
                System.out.print(hall[i][j]);
                if (j < cols - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            c++;
        }
        System.out.println();
        do {
            System.out.println("\uD83C\uDFAC✨ Welcome to the Cinema Booking System \uD83C\uDF7F\uD83C\uDFA5");
            System.out.println("Let’s make your movie experience unforgettable! 🎟️ Choose your seat and enjoy the show!");
            System.out.println("1.Booking seat");
            System.out.println("2.Cancel booked seat");
            System.out.println("3.View Hall");
            System.out.println("4.view history");
            System.out.println("5.Exit");
            System.out.println("Choose an option: ");
            options = input.nextInt();
            switch (options) {

                case 1: {
                    System.out.println();
                    System.out.println("Select your favorite seat \uD83C\uDF9F\uFE0F and enjoy the show \uD83C\uDF7F\uD83C\uDFA5!");
                    System.out.println("1.single seat");
                    System.out.println("2.multiple seat");
                    System.out.println("Choose an option: ");
                    options = input.nextInt();
                    System.out.println();
                    switch (options) {
                        case 1: {
                            System.out.println("Enter the seat code to booking single seat (e.g. A-1) : ");
                            input.nextLine();
                            seatCode = input.nextLine();
                            boolean isFound = false;

                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < cols; j++) {
                                    seats = hall[i][j].split(":");
                                    if (seatCode.equals(seats[0])) {
                                        if (seats[1].trim().equals("AV")) {
                                            isFound = true;
                                            hall[i][j] = seats[0] + ": BO";

                                            LocalDateTime now = LocalDateTime.now();
                                            String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                            bookingHistory[bookingCount][0] = seats[0];
                                            bookingHistory[bookingCount][1] = formattedDate;
                                            bookingCount++;

                                            System.out.println("Seat " + seats[0] + " successfully booked. ");
                                        }
                                    }
                                }
                            }
                            if (!isFound) {
                                System.out.println("Invalid Seat Code");
                            }
                            System.out.println();
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the seats code to booking multiple seats (e.g. A-1,A-2) :");
                            input.nextLine();
                            seatCode = input.nextLine();
                            boolean isFound = false;
                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < cols; j++) {
                                    seats = hall[i][j].split(":");
                                    multiSeatsCode = seatCode.split(",");
                                    for (int k = 0; k < multiSeatsCode.length; k++) {
                                        if (seats[0].equals(multiSeatsCode[k])) {
                                            if (seats[1].trim().equals("AV")) {
                                                isFound = true;
                                                hall[i][j] = seats[0] + ": BO";
                                                LocalDateTime now = LocalDateTime.now();
                                                String formattedDate = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                                                bookingHistory[bookingCount][0] = seats[0];
                                                bookingHistory[bookingCount][1] = formattedDate;
                                                bookingCount++;
                                                System.out.println("Seat " + seats[0] + " successfully booked. ");
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isFound) {
                                System.out.println("Invalid Seat Code");
                            }
                            System.out.println();
                            break;
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Need to cancel your seat? \uD83C\uDFAC Let us assist you! \uD83D\uDCBA✨");
                    System.out.println("1.Cancel single seat");
                    System.out.println("2.Cancel multiple seat");
                    System.out.println("Choose an option: ");
                    options = input.nextInt();
                    System.out.println();
                    switch (options) {
                        case 1: {
                            System.out.println("Enter the seat code to canceling single seat: ");
                            input.nextLine();
                            seatCode = input.nextLine();
                            boolean isFound = false;
                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < cols; j++) {
                                    seats = hall[i][j].split(":");
                                    if (seatCode.equals(seats[0])) {
                                        if (seats[1].trim().equals("BO")) {
                                            isFound = true;
                                            hall[i][j] = seats[0] + ": AV";
                                            System.out.println("Seat " + seats[0] + " successfully cancelled. ");

                                        }
                                    }
                                }
                            }
                            if (!isFound) {
                                System.out.println("Invalid Seat Code");
                            }
                            System.out.println();
                            break;
                        }
                        case 2: {
                            System.out.println("Enter the seats code to cancel multiple seats");
                            input.nextLine();
                            seatCode = input.nextLine();
                            boolean isFound = false;
                            for (int i = 0; i < rows; i++) {
                                for (int j = 0; j < cols; j++) {
                                    seats = hall[i][j].split(":");
                                    multiSeatsCode = seatCode.split(",");
                                    for (int k = 0; k < multiSeatsCode.length; k++) {
                                        if (seats[0].equals(multiSeatsCode[k])) {
                                            if (seats[1].trim().equals("BO")) {
                                                isFound = true;
                                                hall[i][j] = seats[0] + ": AV";
                                                System.out.println("Seat " + seats[0] + " successfully cancelled. ");
                                            }
                                        }
                                    }
                                }
                            }
                            if (!isFound) {
                                System.out.println("Invalid Seat Code");
                            }
                            System.out.println();
                            break;
                        }
                    }
                    break;
                }
                case 3: {
                    System.out.println();
                    System.out.println("\uD83C\uDFAC Explore the seating hall \uD83C\uDFF0 and choose the perfect spot for your movie! \uD83C\uDF7F✨");
                    for (int i = 0; i < rows; i++) {
                        System.out.print("[");
                        for (int j = 0; j < cols; j++) {
                            System.out.print(hall[i][j]);
                            if (j < cols - 1) {
                                System.out.print(", ");
                            }
                        }
                        System.out.println("]");
                    }
                    break;
                }
                    case 4: {
                        System.out.println();
                        System.out.println("\uD83D\uDCC5 Here’s a look at your booking history! \uD83C\uDF9F\uFE0F\uD83C\uDFAC");
                        if (bookingCount == 0) {
                            System.out.println("It seems you haven't booked a ticket yet.");
                        } else {
                            for (int i = 0; i < bookingCount; i++) {
                                System.out.println("\u001B[1;34mDate:\u001B[0m " + bookingHistory[i][1] +
                                        " \u001B[1;33mSeat:\u001B[0m " + bookingHistory[i][0]);
                            }
                            System.out.println("Total Booking : " + bookingCount);
                        }
                        break;
                    }
                case 5: {
                        System.out.println();
                        System.out.println("\uD83C\uDFAC✨ Thank you for choosing our Cinema Booking System! 🎬🎟️");
                        System.out.println("We hope you had an amazing experience! 😍");
                        System.out.println("Goodbye and enjoy your movie time! 👋🎬");
                        break;
                }
            }
        } while (options != 5);
    }
}