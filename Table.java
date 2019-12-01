
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

    public boolean isFree(Date arrDate, int hour) {
        return !reservations.containsKey(getDateTime(arrDate, hour));
    }

    public void reserve(Date arrDate, int hour, int numOfGuests, String custName, String tel) {
        reservations.put(getDateTime(arrDate, hour), new Reservation(numOfGuests, custName));
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
    
    private Calendar getDateTime(Date arrDate, int hour) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(arrDate);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        return cal;
    }
}