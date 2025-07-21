package testingDates;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateAddDaysTest {

    @Test
    public void testAddOneDayStaysInSameMonth_MiddleOfMonth() {
        Date date = new Date("March", 14, 2025);
        Date expected = new Date("March", 15, 2025);
        assertEquals("Middle of March should stay in March", expected, date.addOneDay());
    }

    @Test
    public void testAddOneDayStaysInSameMonth_NearEndButNotLastDay() {
        Date date = new Date("May", 30, 2025);
        Date expected = new Date("May", 31, 2025);
        assertEquals("May 30 + 1 day should be May 31", expected, date.addOneDay());
    }

    @Test
    public void testAddOneDayEndOfJanuaryToFebruary() {
        Date date = new Date("January", 31, 2025);
        Date expected = new Date("February", 1, 2025);
        assertEquals("January 31 + 1 day should be February 1", expected, date.addOneDay());
    }

    @Test
    public void testAddOneDayEndOfAprilToMay() {
        Date date = new Date("April", 30, 2025);
        Date expected = new Date("May", 1, 2025);
        assertEquals("April 30 + 1 day should be May 1", expected, date.addOneDay());
    }

    @Test
    public void testAddOneDayDecember31ToNextYear() {
        Date date = new Date("December", 31, 2025);
        Date expected = new Date("January", 1, 2026);
        assertEquals("December 31 + 1 day should be January 1 of next year", expected, date.addOneDay());
    }

    @Test
    public void testMultipleAddOneDays() {
        Date date = new Date("October", 30, 2025);
        date = date.addOneDay(); // Oct 31
        date = date.addOneDay(); // Nov 1
        Date expected = new Date("November", 1, 2025);
        assertEquals("Two days after Oct 30 should be Nov 1", expected, date);
    }
}

