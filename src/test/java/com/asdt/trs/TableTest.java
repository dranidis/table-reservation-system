package com.asdt.trs;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.Test;

public class TableTest {
    @Test
    public void testReserveTable() {
        Table t = new Table(1, 5);
        LocalDateTime dateTime = LocalDateTime.of(2019, Month.DECEMBER, 15, 11, 00);

        assertTrue(t.isFree(dateTime));
        t.reserve(dateTime, 2, "Alice", "555");
        assertFalse(t.isFree(dateTime));
    }
}
