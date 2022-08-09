public class Flight {
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

		String s1 = String.format("%-12s |", this.getDepartureLocation());
		String s2 = String.format("%-9s | ", this.getArrivalLocation());
		String s3 = String.format("%-11s | ", this.getDepartureDate());
		String s4 = String.format("%-28s |", this.getNumEconomySeats());
		String s5 = String.format("%-43s | ", this.getNumBusinessClassSeats());
		String s6 = String.format("%-30s", this.getNumFirstClassSeats());

		return s1 + s2 + s3 + s4 + s5 + s6;
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
}
