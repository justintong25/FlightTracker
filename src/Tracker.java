import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {
    public ArrayList<Flight> getValues() {
        FileInputStream stream = null;
        try {
            stream = new FileInputStream("src/flightData.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        String strLine;
        ArrayList<Flight> flights = new ArrayList<Flight>();
        try {
            while ((strLine = reader.readLine()) != null) {
                String lastWord = strLine;
                String[] flightAttributes = lastWord.split(",");
                Flight newFlight = new Flight(flightAttributes[0], flightAttributes[1], flightAttributes[2],
                        Integer.parseInt(flightAttributes[3]), Integer.parseInt(flightAttributes[4]),
                        Integer.parseInt(flightAttributes[5]));
                flights.add(newFlight);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return flights;
    }

}
