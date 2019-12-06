package com.asdt.trs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Restaurant {
    private List<Table> tables;

    public int reserveTable(String dateString, int numOfGuests, String name, String tel)
            throws ParseException {
        Calendar arrDateTime = toCalendarTime(dateString);

        // get first available table
        for(Table table: tables) {
            if (table.getMax() >= numOfGuests && table.isFree(arrDateTime)) {
                table.reserve(arrDateTime, numOfGuests, name, tel);
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

    private Calendar toCalendarTime(String dateString) throws ParseException {
        Calendar cal = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
        cal.setTime(sdf.parse(dateString));
        // cal.set(Calendar.HOUR_OF_DAY, hour);
        return cal;
    }

    void printTables() {
        for(Table t: tables) {
            System.out.println(t);
            t.printReservations();
        };
    }
}
