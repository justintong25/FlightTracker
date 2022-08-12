import java.io.IOException;
import java.util.Scanner;

public class Book extends SearchFlights{

    public int id = 1;
    SearchFlights search;

    public Book(String departureLocation, String arrivalLocation, String departureDate, SearchFlights searcher) {
        super(departureLocation, arrivalLocation, departureDate);
        search = searcher;
        //TODO Auto-generated constructor stub
    }

    public Book(String departureLocation, String arrivalLocation, SearchFlights searcher) {
        super(departureLocation, arrivalLocation);
        //TODO Auto-generated constructor stub
        search = searcher;
    }

    @Override
    public void print() throws IOException{

        if(search.searchResult.isEmpty()){
            System.out.println("Flight Not Found.");
        } else {
            System.out.println("Enter the flight you would like to book or 0 to exit.");
            System.out.println("");
            for(Flight f : searchResult){
                System.out.print(id + ". ");
                System.out.println(f);
                id++;
            }

            Scanner scan = new Scanner(System.in);
            boolean valid = true;
            double input = 0;
            do{
                try{
                    String s = scan.nextLine();
                    input = Integer.parseInt(s);
                    input = Math.floor(input);
                    if(input <= id && Integer.signum((int) input) == 1){
                        valid = false;
                        id = (int) input;
                    } else {
                        System.out.println("Please Select A Valid Ticket.");
                    }
                } catch(NumberFormatException e){
                    System.out.println("Invalid Input. Please Try Again or Press 0 To Exit.");
                    valid = true;
                }
            } while(valid && input != 0);


            while(input != 0){
                Flight current = searchResult.get(id - 1);
                if(current.getNumBusinessClassSeats() == 0 && current.getNumEconomySeats() == 0 && current.getNumFirstClassSeats() == 0){
                    System.out.println("The Flight You Have Selected Is Fully Booked. Please Find Another Flight.");
                    break;
                }
                System.out.println("Choose An Available Seat.");
                System.out.println("# Economy Seats| # Business Class Seats| # First Class Seats");
                System.out.printf("%-15s", current.getNumEconomySeats());
                System.out.printf("%-24s", "| " + current.getNumBusinessClassSeats());
                System.out.printf("%-15s", "| " + current.getNumFirstClassSeats());
                System.out.println();
                // System.out.println(current.getNumEconomySeats() + " |        " + current.getNumBusinessClassSeats() + " |    " + current.getNumFirstClassSeats());
                System.out.println("Enter The Amount Of Economy Seats You Would Like To Purchase: ");
                try{
                    boolean economyChecker = false;
                    double economyInput = 0;
                    do{
                        String s = scan.nextLine();
                        economyInput = Integer.parseInt(s);
                        economyInput = Math.floor(economyInput);
                        if(economyInput < 0 || economyInput > current.getNumEconomySeats()){
                            System.out.println("Invalid Ticket Amount. Please Choose The Amount Of Economy Class Tickets Again.");
                            economyChecker = true;
                            continue;
                        }
                        economyChecker = false;
                    } while(economyChecker);
                    System.out.println("Enter The Amount Of Business Class Seats You Would Like To Purchase: ");
                    boolean businessClassChecker = false;
                    double businessClassInput = 0;
                    do{
                        String s = scan.nextLine();
                        businessClassInput = Integer.parseInt(s);
                        businessClassInput = Math.floor(businessClassInput);
                        if(businessClassInput < 0 || businessClassInput > current.getNumBusinessClassSeats()){
                            System.out.println("Invalid Ticket Amount. Please Choose The Amount Of Business Class Tickets Again.");
                            businessClassChecker = true;
                            continue;
                        }
                        businessClassChecker = false;
                    } while(businessClassChecker);
                    System.out.println("Enter The Amount Of First Class Seats You Would Like To Purchase: ");
                    boolean firstClassChecker = false;
                    double firstClassInput = 0;
                    do{
                        String s = scan.nextLine();
                        firstClassInput = Integer.parseInt(s);
                        firstClassInput = Math.floor(firstClassInput);
                        if(firstClassInput < 0 || firstClassInput > current.getNumFirstClassSeats()){
                            System.out.println("Invalid Ticket Amount. Please Choose The Amount Of First Class Tickets Again.");
                            firstClassChecker = true;
                            continue;
                        }
                        firstClassChecker = false;
                    } while(firstClassChecker);

                    if(economyInput == 0 && businessClassInput == 0 && firstClassInput == 0){
                        System.out.println("Exiting without purchasing tickets.");
                        break;
                    }

                    current.setNumEconomySeats(current.getNumEconomySeats() - (int) economyInput);
                    current.setNumBusinessClassSeats(current.getNumBusinessClassSeats() - (int) businessClassInput);
                    current.setNumFirstClassSeats(current.getNumFirstClassSeats() - (int) firstClassInput);
                    System.out.println("Sucessfully Booked");
                    Tracker.editFile(current);
                    break;

                } catch(NumberFormatException e){
                    System.out.println("Invalid Input. Please Reselect Your Seats.");
                    continue;
                }
            }
        }
    }
}
