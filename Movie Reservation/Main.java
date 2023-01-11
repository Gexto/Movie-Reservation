import java.util.Scanner;
//Note
class Main {
  public static void main(String[] args) {

    //Created an object to print out my HashMap from Reservation.java
    Reservation reservation = new Reservation();
    reservation.printMovies();
    System.out.println("Enter the key number to pick a movie to watch");
    
    //The console will then ask the user to enter the key int to pick which movie they prefer to watch.
    Scanner scanInput = new Scanner(System.in);
    int movieInput = scanInput.nextInt();
    reservation.setMovieInput(movieInput);
    

    //created objects for all the rows/seats and added it's values
    FrontRow frontRow = new FrontRow(9, 14, "recline but is a neck breaker", "textile cushions");
    BackRow backRow = new BackRow(9, 14, "somewhat comfortable", "boxy cushions");
    Balcony balcony = new Balcony(22,"a cozy recliner", "leather");

    
    //Prints out options for row seating or more information.
    System.out.println("Reserve a movie Seat of your Choice" + "\n" + "-----------------------------------------------" + "\n" + "Front Row [Enter A]" + "\n" + "Back Row [Enter B}" + "\n" + "Luxury Couches & Dinner on the Balcony [Enter C]" + "\n" + "\n" + "For more information about the seats, enter X" + "\n" + "------------------------------------------------");
    
    //Created an object for 2nd user input
    String rowInput = scanInput.next().toUpperCase();
    reservation.setRowInput(rowInput);
    rowInput = rowInput.toUpperCase();
    
    //The row classes are applied to the buyingTickets(method)
    reservation.buyingTickets(frontRow, backRow, balcony);

    //The last statment printed at the end of the program
    System.out.println("Final Statement: " + reservation.printEverything());
    
}
    
}
