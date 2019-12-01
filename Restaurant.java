import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public class Restaurant {
    private List<Table> tables;

    public int reserveTable(String dateString, int hour, int numOfGuests, String name, String tel)
            throws ParseException {
        Date arrDate = toDate(dateString);

        // get first available table
        Optional<Table> firstAvail = tables.stream()
            .filter(t -> t.getMax() >= numOfGuests)
            .filter(t -> t.isFree(arrDate, hour))
            .findFirst();

        if (firstAvail.isPresent()) {
            Table table = firstAvail.get();
            table.reserve(arrDate, hour, numOfGuests, name, tel);
            return table.getId();
        } else {
            return -1;
        }
    }

    public Restaurant() {
        tables = new ArrayList<Table>();

        Table t1 = new Table(1, 2);
        Table t2 = new Table(2, 4);
        Table t3 = new Table(3, 6);
        Table t4 = new Table(4, 8);
        tables.add(t1);
        tables.add(t2);
        tables.add(t3);
        tables.add(t4);
        
        // SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        // DailyReservations d23 = new DailyReservations();
        // d23.getReservations().add(new Reservation(13, 2, "Dranidis", t4));
        // d23.getReservations().add(new Reservation(13, 3, "Hatzi", t2));

        // try {
        //     reservations.put(sdf.parse("23/11/2019"), d23);
        // } catch (ParseException e) {
        //     e.printStackTrace();
        // }
    }

    private Date toDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date arrDate;
        arrDate = sdf.parse(dateString);
        return arrDate;
    }
}