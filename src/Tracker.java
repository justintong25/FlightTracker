import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Tracker {

    public static ArrayList<Flight> getValues() {
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

    public static void editFile(Flight f) throws IOException{
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("src/flightData.txt"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;
    
            while ((line = file.readLine()) != null) {
                if(line.contains(f.getDepartureLocation()) && line.contains(f.getArrivalLocation()) && line.contains(f.getDepartureDate())){
                    line = f.getDepartureLocation() + "," +f.getArrivalLocation() + "," + f.getDepartureDate() + "," +
                    f.getNumEconomySeats() + "," + f.getNumBusinessClassSeats() + "," + f.getNumFirstClassSeats();
                }
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();
    
            System.out.println(inputStr); // display the original file for debugging

    
            // display the new file for debugging
            System.out.println("----------------------------------\n" + inputStr);
    
            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("src/flightData.txt");
            fileOut.write(inputStr.getBytes());
            fileOut.close();
    
        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
}
