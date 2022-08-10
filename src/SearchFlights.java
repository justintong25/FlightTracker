import java.io.*;
import java.util.ArrayList;

public class SearchFlights extends Choice {
    private Tracker filemanager = new Tracker();
    private ArrayList<Flight> result = filemanager.getValues();
    private ArrayList<Flight> searchResult = new ArrayList<Flight>();
    private String departureLocation;
    private String arrivalLocation;
    private String departureDate;

    public SearchFlights(int choice) {
        super(choice); 
    }

    public SearchFlights(int choice, String departureLocation, String arrivalLocation, String departureDate) {
        super(choice); 
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
    
        for(Flight d : result){
            if (d.getDepartureDate().equals(this.departureDate) && d.getDepartureLocation().equals(this.departureLocation) && d.getArrivalLocation().equals(this.arrivalLocation)) {
                searchResult.add(d);
            }
        }

    }

    public int getChoice(){
        return choice;
    }

    @Override
    public void print(){
        System.out.println("");
        System.out.println("Search Results");
        System.out.println("========================================");
        for(Flight d : searchResult){
            System.out.println(d + " ");
        }
        System.out.println("----------------------------------------");
    }
}
