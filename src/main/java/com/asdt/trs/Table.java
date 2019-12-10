package com.asdt.trs;

import java.time.LocalDateTime;
import java.util.*;

class Table {

    private int id;
    private int max;

    Map<LocalDateTime, Reservation> reservations;

    Table(int id, int max) {
        this.id = id;
        this.max = max;
        this.reservations = new HashMap<>();
    }

    boolean isFree(LocalDateTime arrDateHour) {
        return !reservations.containsKey(arrDateHour);
    }

    void reserve(LocalDateTime arrDateHour, int numOfGuests, String custName, String tel) {
        reservations.put(arrDateHour, new Reservation(numOfGuests, custName));
    }

    int getMax() {
        return max;
    }

    int getId() {
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
