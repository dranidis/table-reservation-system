public class Reservation {
    private int hour;
    private String custName;
    private int numOfGuests;

	public Reservation(int hour, int numOfGuests, String custName) {
        this.hour = hour;
        this.custName = custName;
        this.numOfGuests = numOfGuests;
    }
    
    public String toString() {
        return String.format("Hour: %2d - coming: %d persons at name: %s",  hour, numOfGuests, custName);
    }

	public int getHour() {
		return hour;
	}
    
}