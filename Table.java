
import java.util.*;
public class Table {

	private int id;
    private int max;

    Map<Calendar, Reservation> reservations;

    public Table(int id, int max) {
        this.id = id;
        this.max = max;
        this.reservations = new HashMap<>();
    }

    public boolean isFree(Calendar arrDateHour) {
        return !reservations.containsKey(arrDateHour);
    }

    public void reserve(Calendar arrDateHour, int numOfGuests, String custName, String tel) {
        reservations.put(arrDateHour, new Reservation(numOfGuests, custName));
    }
    
    public String toString() {
        return String.format("Table: %d - MAX: %d", id, max);
    }

	public int getMax() {
		return max;
	}

	public int getId() {
		return id;
	}
}