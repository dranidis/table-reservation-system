package com.asdt.trs;

import java.text.ParseException;

public class Main {
    public static void main(String a[]) {
        Restaurant r = new Restaurant();
        execReserveTableScenario(r, "23/11/2019 13", 6, "John", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 6, "Maria", "699555111");
        execReserveTableScenario(r, "23/11/2019 13", 6, "Jim", "699333555");
        execReserveTableScenario(r, "23/11/2019 13", 4, "Tom", "699551115");
        execReserveTableScenario(r, "23/11/2019 13", 2, "Alice", "699515555");
        execReserveTableScenario(r, "23/11/2019 13", 2, "Bob", "699552255");
        execReserveTableScenario(r, "24/11/2019 13", 8, "Henry", "699555445");
        execReserveTableScenario(r, "25/11/2019 13", 10, "Tim", "699335555");

        r.printTables();
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
