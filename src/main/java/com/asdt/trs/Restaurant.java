package com.asdt.trs;

import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Restaurant {
    private List<Table> tables = new ArrayList<>();;

    /**
     * Returns the first available table id for the specific date and time.
     *
     * @param dateString
     * @param numOfGuests
     * @param name
     * @param tel
     * @return
     * @throws ParseException
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
