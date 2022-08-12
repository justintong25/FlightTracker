import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MainMenu {
    static Choice choice;

    public static Choice printMenu(){
        String selection = "";
        int select = 0;
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
            select = Integer.parseInt(selection);
            if(select == 1){
                choice = new SearchFlights();
            } else if (select == 2){
                choice = new ShowAll();
            } else if (select == 3){
                choice = new Quit(select);
            }
        } catch(NumberFormatException e) {
            System.out.println("Please Enter a Valid Number.");
            System.out.println("");
        }
        // scan.close(); // added
        //cant close scanner or else the scanner does not run in the next iteration
        return choice;
    }

    public static void main(String[] args) throws IOException{
        Choice userSelection;

        do{
            userSelection = printMenu();
            userSelection.print();

        } while(userSelection.getChoice() != 3);
    }
}
