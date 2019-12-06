package com.asdt.trs;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;

import org.junit.Test;

public class TableReservationTest {
  @Test
  public void testReservationScenarios() {
    Restaurant r = new Restaurant();
    assertEquals(3, execReserveTableScenario(r, "23/11/2019 13", 6, "Dranidis", "699555555"));
    assertEquals(4, execReserveTableScenario(r, "23/11/2019 13", 6, "Dranidis", "699555555"));
    assertEquals(-1, execReserveTableScenario(r, "23/11/2019 13", 6, "Dranidis", "699555555"));
    assertEquals(2, execReserveTableScenario(r, "23/11/2019 13", 4, "Dranidis", "699555555"));
    assertEquals(1, execReserveTableScenario(r, "23/11/2019 13", 2, "Dranidis", "699555555"));
    assertEquals(-1, execReserveTableScenario(r, "23/11/2019 13", 2, "Dranidis", "699555555"));
    assertEquals(4, execReserveTableScenario(r, "24/11/2019 13", 8, "Dranidis", "699555555"));
    assertEquals(-1, execReserveTableScenario(r, "25/11/2019 13", 10, "Dranidis", "699555555"));
  }

  public int execReserveTableScenario(Restaurant r, String dateString, int numOfGuests, String name, String tel) {
    int tableId = -1;
    try {
        tableId = r.reserveTable(dateString, numOfGuests, name, tel);
    } catch (ParseException e) {
        e.printStackTrace();
    }
    return tableId;
}


}
