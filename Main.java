import java.text.ParseException;

public class Main {
    public static void main(String a[]) {
        Restaurant r = new Restaurant();
        try {

            int tId = r.reserveTable("23/11/2019", 13, 4, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("23/11/2019", 13, 4, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("23/11/2019", 13, 4, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("23/11/2019", 13, 4, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("23/11/2019", 13, 2, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("23/11/2019", 13, 2, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("24/11/2019", 13, 8, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
            tId = r.reserveTable("25/11/2019", 13, 10, "Dranidis", "699555555");
            System.out.println("Reserved: " + tId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }    
}