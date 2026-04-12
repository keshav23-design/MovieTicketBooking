import java.util.Scanner;
import java.util.ArrayList;

// Movie class
class Movie {
    String movieName;
    String showTime;

    Movie(String movieName, String showTime) {
        this.movieName = movieName;
        this.showTime = showTime;
    }

    String getMovieName() {
        return movieName;
    }

    String getShowTime() {
        return showTime;
    }
}

// Seat class
class Seat {
    String type;   // Regular or Premium
    double price;
    boolean isBooked;

    Seat(String type, double price) {
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }
}

// Booking class - handles seat booking
class Booking {
    Seat[][] seats;
    double totalCost;
    int rows;
    int cols;

    Booking(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.totalCost = 0;
        seats = new Seat[rows][cols];

        // first 2 rows premium, rest regular
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < 2) {
                    seats[i][j] = new Seat("Premium", 300);
                } else {
                    seats[i][j] = new Seat("Regular", 150);
                }
            }
        }
    }

    boolean bookSeat(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Invalid seat!");
            return false;
        }

        if (seats[row][col].isBooked == true) {
            System.out.println("Seat already booked! Choose another.");
            return false;
        }

        seats[row][col].isBooked = true;
        totalCost = totalCost + seats[row][col].price;
        System.out.println("Seat (" + (row + 1) + "," + (col + 1) + ") booked!");
        return true;
    }

    boolean cancelSeat(int row, int col) {
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            System.out.println("Invalid seat!");
            return false;
        }

        if (seats[row][col].isBooked == false) {
            System.out.println("Seat was not booked.");
            return false;
        }

        seats[row][col].isBooked = false;
        totalCost = totalCost - seats[row][col].price;
        System.out.println("Seat (" + (row + 1) + "," + (col + 1) + ") cancelled.");
        return true;
    }

    void displaySeats() {
        System.out.println();
        System.out.println("-------- Seat Layout --------");
        System.out.println("O = Available  X = Booked");
        System.out.println("Row 1-2 = Premium (Rs.300)  Row 3-5 = Regular (Rs.150)");
        System.out.println();

        System.out.print("     ");
        for (int j = 0; j < cols; j++) {
            System.out.print("C" + (j + 1) + "  ");
        }
        System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.print("R" + (i + 1) + "   ");
            for (int j = 0; j < cols; j++) {
                if (seats[i][j].isBooked == true) {
                    System.out.print(" X  ");
                } else {
                    System.out.print(" O  ");
                }
            }
            System.out.println();
        }
        System.out.println("-----------------------------");
        System.out.println();
    }
}

public class MovieTicketBooking {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("     Welcome to Movie Ticket Booking     ");
        System.out.println("=========================================");
        System.out.println();

        Movie[] movies = new Movie[4];
        movies[0] = new Movie("Avengers Doomsday", "10:00 AM");
        movies[1] = new Movie("KGF Chapter 3", "01:30 PM");
        movies[2] = new Movie("Pushpa 3", "05:00 PM");
        movies[3] = new Movie("Mission Impossible 8", "08:30 PM");

        System.out.println("Available Movies:");
        System.out.println("-----------------");
        for (int i = 0; i < movies.length; i++) {
            System.out.println((i + 1) + ". " + movies[i].getMovieName() + "  |  " + movies[i].getShowTime());
        }
        System.out.println();

        System.out.print("Select movie (1-4): ");
        int movieChoice = sc.nextInt();
        movieChoice = movieChoice - 1;

        // if wrong input just default to first movie
        if (movieChoice < 0 || movieChoice > 3) {
            System.out.println("Wrong input, selecting first movie.");
            movieChoice = 0;
        }

        Movie selectedMovie = movies[movieChoice];
        System.out.println();
        System.out.println("You selected: " + selectedMovie.getMovieName() + " at " + selectedMovie.getShowTime());
        System.out.println();

        Booking booking = new Booking(5, 6);

        // using arraylist to store seat numbers - learned this in class
        ArrayList<String> bookedSeatsList = new ArrayList<String>();

        int choice = 0;

        while (choice != 4) {

            booking.displaySeats();

            System.out.println("1. Book seat");
            System.out.println("2. Cancel seat");
            System.out.println("3. View booking");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            if (choice == 1) {

                System.out.print("Enter row: ");
                int row = sc.nextInt();
                System.out.print("Enter column: ");
                int col = sc.nextInt();

                boolean x = booking.bookSeat(row - 1, col - 1);

                if (x == true) {
                    bookedSeatsList.add("(" + row + "," + col + ")");
                }

            } else if (choice == 2) {

                System.out.print("Enter row to cancel: ");
                int row = sc.nextInt();
                System.out.print("Enter column to cancel: ");
                int col = sc.nextInt();

                boolean y = booking.cancelSeat(row - 1, col - 1);
                if (y == true) {
                    bookedSeatsList.remove("(" + row + "," + col + ")");
                }              
            } else if (choice == 3) {

                System.out.println();
                System.out.println("========== BOOKING CONFIRMATION ==========");
                System.out.println("Movie     : " + selectedMovie.getMovieName());
                System.out.println("Show Time : " + selectedMovie.getShowTime());
                System.out.println("Seats     : " + bookedSeatsList);
                System.out.println("Total     : Rs." + (int) booking.totalCost);
                System.out.println("==========================================");
                System.out.println("         Booking Confirmed!               ");
                System.out.println("==========================================");
                System.out.println();

            } else if (choice == 4) {
                System.out.println("Thankyou! Goodbye!");

            } else {
                System.out.println("Wrong choice!");
            }
        }

        sc.close();
    }
}