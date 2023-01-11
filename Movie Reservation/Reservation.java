import java.util.HashMap;
import java.util.Scanner;

public class Reservation
{
    private int childPrice = 9;
    private int adultPrice = 14;
    private int balconyAdultPrice = 22;
    public int movieInput;
    public String rowInput;
    public double pricesAdded;
    public String typeRow;
    public int ticketNumber;
    public double total;
    public HashMap<Integer, String> movies;


    //Created a HashMap for movies to select
    public Reservation(){  
      movies = new HashMap<Integer, String>();
      movies.put(1, "The Godmother II");
      movies.put(2, "The Revengers");
      movies.put(3, "Karate Panda 4");
      movies.put(4, "The Big Mermaid");
    }
  
    //This getter returns the index value from the key the user inputs (the first int input). The getter is printed at the printEverything() method.
    public String getMovieTitle(int indx)
    {
       return "'"+movies.get(indx)+"'";
    }
    //Getters for typeRow, movieInput and rowInput
    public double getPricesAdded()
    {
       return pricesAdded;
    }
    
    public String getTypeRow()
    {
      return typeRow;
    }
  
    public int getMovieInput()
    {
      return movieInput;
    }
  
    public String getRowInput()
    {
      return rowInput;
    }
  
  //Setters for typeRow, pricesAdded, movieInput and rowInput
    public void setTypeRow(String typeRow)
    {
      this.typeRow = typeRow;
    }
    
    public void setRowInput(String rowInput)
    {
      this.rowInput = rowInput;
    }
    
    public void setMovieInput(int movieInput)
    {
      this.movieInput = movieInput;
    }
  
    public void setPricesAdded(double pricesAdded)
    {
      this.pricesAdded = pricesAdded;
    }
  
    //Method to print out the HashMap
    public void printMovies()
    {
      //method to print out the HashMap keys and values
      this.movies.entrySet().forEach(entry -> {
          System.out.println(entry.getKey() + " " + entry.getValue());
      });
    }
  
//####################################################################################################
  public void buyingTickets(FrontRow frontRow, BackRow backRow, Balcony balcony)
  {
    Scanner myObj = new Scanner(System.in);

    while(true)
    {
      switch (getRowInput()) 
      {
        case "X":
        {
          //Prints out the methods from the row classes to info about the rows.
            frontRow.printInfo();
            backRow.printInfo();
            balcony.printInfo();
            System.out.println("Enter N and restart the program to purchase tickets");
          break;
        }
        //Next step after the user inputs the chararcter A
  //-------------------------------------------------------------------------
        case "A":
        { 
            //The user's input creates a string for printEverything()
            typeRow = "Front Row";
          
            //The console prints the message asking the user if the tickets they are buying is a child or adult's.
            System.out.println("Child [enter V] or Adult [enter L] ticket?");
          
            //Saves user's input into an object
            String typePerson = myObj.next();
            typePerson = typePerson.toUpperCase();
          
            //When the user is asked if its a child or adult ticket, the user will be asked how many tickets.
            if(typePerson.equals("V"))
            {
              //The console will then ask the user how many tickets they want to purchase
              System.out.println("-----------------" + "\n" + "How Many Tickets?");
              
              ticketNumber = myObj.nextInt();
              //The user input for number of tickets multiplies with the price of child tickets
              pricesAdded = ticketNumber * childPrice;
            }
            else if(typePerson.equals("L"))
            {
              System.out.println("-----------------" + "\n" + "How Many Tickets?");
              ticketNumber = myObj.nextInt();
              //The user input for number of tickets multiplies with the price of adult tickets
              pricesAdded = ticketNumber * adultPrice;
            }
            //Result when the user input the wrong character
            else
            {
              System.out.println("Wrong letter!");
            }    
        break;
        }
  //-----------------------------------------------------------------------
    
    //Case b is when user enters the chararcter C, repeats the steps from A and B
        case "B":
        {
          typeRow = "Back Row";
          System.out.println("Child [enter V] or Adult [enter L] ticket?");
          String typePerson = myObj.nextLine();
          typePerson = typePerson.toUpperCase();
          if(typePerson.equals("V"))
          {
            System.out.println("-----------------" + "\n" + "How Many Tickets?");
            ticketNumber = myObj.nextInt();
            pricesAdded = ticketNumber * childPrice;
          }
          else if(typePerson.equals("L"))
          {
          System.out.println("-----------------" + "\n" + "How Many Tickets?");
            ticketNumber = myObj.nextInt();
            pricesAdded = ticketNumber * adultPrice;
            }
          else
          {
            System.out.println("Wrong letter!");
          }
        break;
        }      
  
  //-----------------------------------------------------------------------
    //Next step after the user inputs the chararcter C, no child-tickets are available so it skips the step of asking the user if it's a "child or adult" ticket.
        case "C":
        {
            typeRow = "Balcony";
            System.out.println("-----------------" + "\n" + "How Many Tickets?");
            ticketNumber = myObj.nextInt();
            //User's input of how many tickets they want to purchase is added with the price of an adult-ticket on a couch
          
            pricesAdded = ticketNumber * balconyAdultPrice;
      // If the users input is an invalid character it goes back to the top of the loop.
      if(ticketNumber != (int)ticketNumber)
        {
            System.out.println("Wrong character, must be a number!");
        }
      break;
      }
      }
      //After the switch/cases, the program will then ask you if wish to buy more tickets.
          System.out.println("Would you like to purchase more tickets? Enter yes[Y] or no[N]");
      
            String answer = myObj.next();
            answer = answer.toUpperCase();
            if(answer.equals("Y"))
            {
              continue;
            }
            else if(answer.equals("N"))
            {
              break;
            }
            else
            {
              System.out.println("Wrong letter!, enter only 'Y' or 'N'");
            }
            
    }
    myObj.close();
     
}
//####################################################################################################

  public double getTotalPrice()
  {
    //Multiplies the number of tickets to the tax percantage to get the tax number
    try
    {
        double tax = 0.5 * pricesAdded;
        //Adds tax and the number
        total = tax + pricesAdded;
        return total;
    }
      catch(Exception e)
      {
        return 0.0;
      }
  }

  public String printEverything()
  {
    return "You have reserved " + ticketNumber + " ticket(s) in the " + typeRow + ", for the movie " + getMovieTitle(movieInput) + ". Your total will be $" + getTotalPrice();
  }
  
  
}
