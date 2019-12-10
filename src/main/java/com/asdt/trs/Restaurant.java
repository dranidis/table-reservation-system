package com.asdt.trs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Restaurant {
    private List<Table> tables = new ArrayList<>();;

    /**
     * Returns the first available table id for the specific date and time.
     * Returns -1 if no table is found.
     *
     * @param dateString the date and time of the request in the format "dd/MM/yyyy HH"
     * @param numOfGuests the number of guests. The table should be at least of this size.
     * @param name the name of the customer who makes the reservation
     * @param tel the tel of the customer
     * @return the id of the first available table. -1 if no table is found.
     */
    public int reserveTable(String dateString, int numOfGuests, String name, String tel) {
        LocalDateTime arrDateTime = toDateTime(dateString);

        // get first available table
        for (Table table : tables) {
            if (table.getMax() >= numOfGuests && table.isFree(arrDateTime)) {
                table.reserve(arrDateTime, numOfGuests, name, tel);
                return table.getId();
            }
        }
        return -1;
    }
    /**
     * Adds a table to the restaurant
     * @param id the id of the table. A positive integer number.
     * @param max the maximum number of diners.
     */
    public void addTable(int id, int max) {
        tables.add(new Table(id, max));
    }

    private LocalDateTime toDateTime(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH");
        return LocalDateTime.parse(dateString, formatter);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nRESTAURANT TABLE RESERVATIONS\n");
        for (Table t : tables) {
            sb.append(t);
        }
        return sb.toString();
    }
}
