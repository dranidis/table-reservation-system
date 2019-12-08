package com.asdt.trs;

public class Main {
    public static void main(String a[]) {
        Restaurant r = new Restaurant();
        r.addTable(1, 2);
        r.addTable(2, 4);
        r.addTable(3, 6);
        r.addTable(4, 8);

        execReserveTableScenario(r, "23/11/2019 13", 6, "John", "699555555");
        execReserveTableScenario(r, "23/11/2019 13", 6, "Maria", "699555111");
        execReserveTableScenario(r, "23/11/2019 13", 6, "Jim", "699333555");
        execReserveTableScenario(r, "23/11/2019 13", 4, "Tom", "699551115");
        execReserveTableScenario(r, "23/11/2019 13", 2, "Alice", "699515555");
        execReserveTableScenario(r, "23/11/2019 13", 2, "Bob", "699552255");
        execReserveTableScenario(r, "24/11/2019 13", 8, "Henry", "699555445");
        execReserveTableScenario(r, "25/11/2019 13", 10, "Tim", "699335555");

        // uncomment if you want to print the restaurant info.
        System.out.println(r);
    }

    public static void execReserveTableScenario(Restaurant r, String dateString, int numOfGuests, String name,
            String tel) {
        int tId = r.reserveTable(dateString, numOfGuests, name, tel);
        if (tId != -1)
            System.out.println("Reserved table: " + tId);
        else
            System.out.println("No available table");
    }
}
