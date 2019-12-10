package com.asdt.trs;

class Reservation {
    private String custName;
    private int numOfGuests;

	Reservation(int numOfGuests, String custName) {
        this.custName = custName;
        this.numOfGuests = numOfGuests;
    }

    public String toString() {
        return String.format("%d persons at name: %s", numOfGuests, custName);
    }
}
