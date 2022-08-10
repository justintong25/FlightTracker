import java.util.List;
import java.util.Scanner;

import javax.swing.JTable.PrintMode;

public class MainMenu {
    static Choice choice;

    public static Choice printMenu(){
        String selection = "";
        choice = new Choice(0);
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Main Window");
            System.out.println("========================================");
            System.out.println("Choose one of the following options: ");
            System.out.println("(1) Search For A Flight");
            System.out.println("(2) Show All Flights");
            System.out.println("(3) Quit");
            System.out.println("Enter your choice: ");
            selection = scan.nextLine();
            choice.setChoice(Integer.parseInt(selection));
        } catch(NumberFormatException e) {
            System.out.println("Please Enter a Valid Number.");
            System.out.println("");
        }
        return choice;
    }

    public static void main(String[] args){
        Choice userSelection;

        do{
            userSelection = printMenu();
            switch(userSelection.getChoice()){
                case 1:
                    //Add Search For Flight Here
                    Scanner search = new Scanner(System.in);

                    System.out.println("Enter departure location (e.g., LGA):");
                    String departureLocation = search.nextLine();

                    System.out.println("Enter arrival location (e.g., LAX):");
                    String arrivalLocation = search.nextLine();

                    System.out.println("Enter departure date (as MM/DD/YYYY):");
                    String departureDate = search.nextLine();

                    userSelection = new SearchFlights(userSelection.getChoice(), departureLocation, arrivalLocation, departureDate);
                    
                    userSelection.print();
                    System.out.println("");
                    break;
                case 2:
                    userSelection = new ShowAll(userSelection.getChoice());
                    userSelection.print();
                    System.out.println("");
                    break;
                case 3: 
                    System.out.println("Quitting.");
                    break;
                default: 
                    System.out.println("Invalid Input. Please Try Again");
                    System.out.println("");
                    break;
            }
        } while(userSelection.getChoice() != 3);
    }
}
