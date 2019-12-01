package trs;

import java.text.ParseException;

public class Main {
    public static void main(String a[]) {
        Restaurant r = new Restaurant();
        execReserveTableScenario(r, "23/11/2019 13", 6, "Dranidis", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 6, "Dranidis", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 6, "Dranidis", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 4, "Dranidis", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 2, "Dranidis", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 2, "Dranidis", "699555555");
        execReserveTableScenario(r, "24/11/2019 13", 8, "Dranidis", "699555555");
        execReserveTableScenario(r, "25/11/2019 13", 10, "Dranidis", "699555555");
    }

    public static void execReserveTableScenario(Restaurant r, String dateString, int numOfGuests, String name, String tel) {
        try {
            int tId = r.reserveTable(dateString, numOfGuests, name, tel);
            if (tId != -1)
                System.out.println("Reserved: " + tId);
            else
                System.out.println("Failed");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
