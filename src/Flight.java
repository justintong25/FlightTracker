public class Flight {
	private int numEconomySeats;
	private int numBusinessClassSeats;
	private int numFirstClassSeats;
	private String departureLocation;
	private String departureDate;
	private String arrivalDate;
	private String arrivalLocation;
	
	public Flight(int numEconomySeats, int numBusinessClassSeats, int numFirstClassSeats, 
			String departureLocation, String arrivalLocation, String departureDate, String arrivalDate) {
		
		this.numEconomySeats = numEconomySeats;
		this.numBusinessClassSeats = numBusinessClassSeats;
		this.numFirstClassSeats = numFirstClassSeats;
		this.departureLocation = departureLocation;
		this.arrivalLocation = departureLocation;
		this.departureDate = departureDate;
		this.arrivalDate = arrivalDate;
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

	public String getArrivalDate() {
		return arrivalDate;
	}

	public void setArrivalDate(String arrivalDate) {
		this.arrivalDate = arrivalDate;
	}
}
