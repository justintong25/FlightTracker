import java.util.ArrayList;

public class SearchFlights extends Choice {
    private Tracker filemanager = new Tracker();
    private ArrayList<Flight> result = filemanager.getValues();
    // `searchResult` is the sublist of query-matching Flights from `result`
    private ArrayList<Flight> searchResult = new ArrayList<Flight>();
    private String departureLocation;
    private String arrivalLocation;
    private String departureDate;

    // default constructor
    public SearchFlights(int choice) {
        super(choice); 
    }

    // constructor invoked in MainMenu with all necessary search parameters
    public SearchFlights(int choice, String departureLocation, String arrivalLocation, String departureDate) {
        super(choice); 
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

    public int getChoice(){
        return choice;
    }

    @Override
    // Override `Choice` print to print query-matching results
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
