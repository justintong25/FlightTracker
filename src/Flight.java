import java.io.Serializable;

public class Flight implements Serializable {
	private String departureLocation;
	private String departureDate;
	private String arrivalLocation;
	private int numEconomySeats;
	private int numBusinessClassSeats;
	private int numFirstClassSeats;

	public Flight(String departureLocation, String arrivalLocation, String departureDate,
			int numEconomySeats, int numBusinessClassSeats, int numFirstClassSeats) {

		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDate = departureDate;
		this.numEconomySeats = numEconomySeats;
		this.numBusinessClassSeats = numBusinessClassSeats;
		this.numFirstClassSeats = numFirstClassSeats;
	}

	@Override
	public String toString() {

		System.out.printf("%-11s", this.getDepartureLocation());
		System.out.printf("%-10s", "| " + this.getArrivalLocation());
		System.out.printf("%-10s", "| " + this.getDepartureDate());
		System.out.printf("%-10s", "| " + this.getNumEconomySeats());
		System.out.printf("%-10s", "| " + this.getNumBusinessClassSeats());
		System.out.printf("%-10s", "| " + this.getNumFirstClassSeats());
		System.out.println("");


		return "";
	}

	public int getNumEconomySeats() {
		return numEconomySeats;
	}

	public void setNumEconomySeats(int numEconomySeats) {
		this.numEconomySeats = numEconomySeats;
	}

	public int getNumBusinessClassSeats() {
		return numBusinessClassSeats;
	}

	public void setNumBusinessClassSeats(int numBusinessClassSeats) {
		this.numBusinessClassSeats = numBusinessClassSeats;
	}

	public int getNumFirstClassSeats() {
		return numFirstClassSeats;
	}

	public void setNumFirstClassSeats(int numFirstClassSeats) {
		this.numFirstClassSeats = numFirstClassSeats;
	}

	public String getDepartureLocation() {
		return departureLocation;
	}

	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}

	public String getArrivalLocation() {
		return arrivalLocation;
	}

	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}

	public String getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(String departureDate) {
		this.departureDate = departureDate;
	}

	public Flight updateSeats(Flight f){
		f.setNumBusinessClassSeats(this.numBusinessClassSeats - f.getNumBusinessClassSeats());
		f.setNumFirstClassSeats(this.numFirstClassSeats - f.getNumFirstClassSeats());
		f.setNumEconomySeats(this.numEconomySeats- f.getNumBusinessClassSeats());
		return f;
	}
}
