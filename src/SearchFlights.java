import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchFlights extends Choice {
    private Tracker filemanager = new Tracker();
    protected ArrayList<Flight> result = filemanager.getValues();
    // `searchResult` is the sublist of query-matching Flights from `result`
    protected ArrayList<Flight> searchResult = new ArrayList<Flight>();
    private String departureLocation;
    private String arrivalLocation;
    private String departureDate;

    // default constructor
    public SearchFlights(int choice) {
        super(choice); 
    }

    // constructor invoked in MainMenu with all necessary search parameters
    public SearchFlights(String departureLocation, String arrivalLocation, String departureDate) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
        this.departureDate = departureDate;
    
        // build searchResult
        for(Flight d : result){
            if (d.getDepartureDate().equals(this.departureDate) && d.getDepartureLocation().equals(this.departureLocation) && d.getArrivalLocation().equals(this.arrivalLocation)) {
                searchResult.add(d);
            }
        }

    }

    public SearchFlights(String departureLocation, String arrivalLocation) {
        this.departureLocation = departureLocation;
        this.arrivalLocation = arrivalLocation;
    
        // build searchResult
        for(Flight d : result){
            if (d.getDepartureLocation().equals(this.departureLocation) && d.getArrivalLocation().equals(this.arrivalLocation)) {
                searchResult.add(d);
            }
        }

    }

    

    public SearchFlights() {
    }

    public int getChoice(){
        return choice;
    }

    @Override
    // Override `Choice` print to print query-matching results
    public void print() throws IOException{
        Scanner search = new Scanner(System.in);
        System.out.println("Enter departure location (e.g., LGA):");
        String departureLocation = search.nextLine();
        departureLocation = departureLocation.toUpperCase();
        System.out.println("Enter arrival location (e.g., LAX):");
        String arrivalLocation = search.nextLine();
        arrivalLocation = arrivalLocation.toUpperCase();
        System.out.println("Enter departure date (as MM/DD/YYYY) or Press Enter To Show All Dates :");
        String departureDate = search.nextLine();
        SearchFlights searcher;
        Book book;
        if(departureDate.isEmpty()){
            searcher = new SearchFlights(departureLocation, arrivalLocation);
            book = new Book(departureLocation, arrivalLocation, searcher);
        } else {
            searcher = new SearchFlights(departureLocation, arrivalLocation, departureDate);
            book = new Book(departureLocation, arrivalLocation, departureDate, searcher);
        }
        System.out.println("");
        System.out.println("Search Results");
        System.out.println("========================================");
        for(Flight d : searcher.searchResult){
            System.out.println(d + " ");
        }
        System.out.println("----------------------------------------");

        book.print();
    }
}
