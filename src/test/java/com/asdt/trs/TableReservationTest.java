package com.asdt.trs;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TableReservationTest {
  @Test
  public void testReservationScenarios() {
    Restaurant r = new Restaurant();
    r.addTable(1, 2);
    r.addTable(2, 4);
    r.addTable(3, 6);
    r.addTable(4, 8);

    assertEquals(3, r.reserveTable("23/11/2019 13", 6, "Dranidis", "699555555"));
    assertEquals(4, r.reserveTable("23/11/2019 13", 6, "Dranidis", "699555555"));
    assertEquals(-1, r.reserveTable("23/11/2019 13", 6, "Dranidis", "699555555"));
    assertEquals(2, r.reserveTable("23/11/2019 13", 4, "Dranidis", "699555555"));
    assertEquals(1, r.reserveTable("23/11/2019 13", 2, "Dranidis", "699555555"));
    assertEquals(-1, r.reserveTable("23/11/2019 13", 2, "Dranidis", "699555555"));
    assertEquals(4, r.reserveTable("24/11/2019 13", 8, "Dranidis", "699555555"));
    assertEquals(-1, r.reserveTable("25/11/2019 13", 10, "Dranidis", "699555555"));
  }
}
