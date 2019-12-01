
import java.util.*;
public class Table {

	private int id;
    private int max;

    Map<Date, Map<Integer, Reservation>> reservations;

    public Table(int id, int max) {
        this.id = id;
        this.max = max;
        this.reservations = new HashMap<Date, Map<Integer, Reservation>>();
    }

    public boolean isFree(Date arrDate, int hour) {
        // Get the reservations for the date
        Map<Integer, Reservation> dailyReservations = reservations.get(arrDate);
        if (dailyReservations == null) {
            return true;
        }

        if (dailyReservations.get(new Integer(hour)) == null) {
            return true;
        } else {
            return false;
        }
    }

    public void reserve(Date arrDate, int hour, int numOfGuests, String custName, String tel) {
        // Get the reservations for the date
        Map<Integer, Reservation> dailyReservations = reservations.get(arrDate);
        if (dailyReservations == null) {
            dailyReservations = new HashMap<Integer, Reservation>(); 
            reservations.put(arrDate, dailyReservations);
        }
        dailyReservations.put(new Integer(hour), new Reservation(hour, numOfGuests, custName));

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