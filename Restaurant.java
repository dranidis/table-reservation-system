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
        for(Table table: tables) {
            if (table.getMax() >= numOfGuests && table.isFree(arrDate, hour)) {
                table.reserve(arrDate, hour, numOfGuests, name, tel);
                return table.getId();
            }
        }
        return -1;
    }

    public Restaurant() {
        tables = new ArrayList<>();

        Table t1 = new Table(1, 2);
        Table t2 = new Table(2, 4);
        Table t3 = new Table(3, 6);
        Table t4 = new Table(4, 8);
        tables.add(t1);
        tables.add(t2);
        tables.add(t3);
        tables.add(t4);
    }

    private Date toDate(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date arrDate;
        arrDate = sdf.parse(dateString);
        return arrDate;
    }
}