package com.asdt.trs;

public class Reservation {
    private String custName;
    private int numOfGuests;

	public Reservation(int numOfGuests, String custName) {
        this.custName = custName;
        this.numOfGuests = numOfGuests;
    }

    public String toString() {
        return String.format("coming: %d persons at name: %s", numOfGuests, custName);
    }
}
