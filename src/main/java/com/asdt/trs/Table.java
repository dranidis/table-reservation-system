package com.asdt.trs;

import java.time.LocalDateTime;
import java.util.*;

public class Table {

    private int id;
    private int max;

    Map<LocalDateTime, Reservation> reservations;

    public Table(int id, int max) {
        this.id = id;
        this.max = max;
        this.reservations = new HashMap<>();
    }

    public boolean isFree(LocalDateTime arrDateHour) {
        return !reservations.containsKey(arrDateHour);
    }

    public void reserve(LocalDateTime arrDateHour, int numOfGuests, String custName, String tel) {
        reservations.put(arrDateHour, new Reservation(numOfGuests, custName));
    }

    public int getMax() {
        return max;
    }

    public int getId() {
        return id;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Table: %d - MAX: %d\n", id, max));
        reservations.forEach((k, v) -> sb.append(String.format("\tDate: %s/%s/ %s: %s\n",
                k.getDayOfMonth(), k.getMonth(),
                k.getHour(), v)));
        return sb.toString();
    }
}
