package testingDates;

import static org.junit.Assert.*;
import org.junit.Test;

public class DateSetDateTest {

    @Test
    public void testLegalDateChange() {
        Date bob = new Date(1, 1, 2020); // Jan 1, 2020
        bob.setDate("February", 28, 2021);
        Date expected = new Date("February", 28, 2021);
        assertEquals("Should change to Feb 28, 2021", expected, bob);
    }

    @Test
    public void testIllegalDateChangeToFeb30() {
        Date bob = new Date(2, 15, 2021); // Feb 15, 2021
        Date before = new Date("February", 15, 2021);
        bob.setDate("February", 30, 2021); // Invalid: Feb has 28 days
        assertEquals("Should remain unchanged after invalid setDate", before, bob);
    }

    @Test
    public void testIllegalDateChangeToApril31() {
        Date bob = new Date(4, 10, 2022); // April 10, 2022
        Date before = new Date("April", 10, 2022);
        bob.setDate("April", 31, 2022); // April has only 30 days
        assertEquals("Should remain unchanged after invalid April 31", before, bob);
    }

    @Test
    public void testLegalDateChangeToEndOfMonth() {
        Date bob = new Date(7, 10, 2023); // July 10, 2023
        bob.setDate("July", 31, 2023); // Valid
        Date expected = new Date("July", 31, 2023);
        assertEquals("Should change to July 31, 2023", expected, bob);
    }

    @Test
    public void testIllegalMonthString() {
        Date bob = new Date(6, 1, 2023); // June 1, 2023
        Date before = new Date("June", 1, 2023);
        bob.setDate("Smarch", 15, 2023); // Not a real month
        assertEquals("Should remain unchanged after bogus month", before, bob);
    }

    @Test
    public void testIllegalDayZero() {
        Date bob = new Date(3, 1, 2024); // March 1, 2024
        Date before = new Date("March", 1, 2024);
        bob.setDate("March", 0, 2024); // Invalid day
        assertEquals("Should remain unchanged after setting day 0", before, bob);
    }

    @Test
    public void testIllegalNegativeYear() {
        Date bob = new Date(10, 5, 2023);
        Date before = new Date("October", 5, 2023);
        bob.setDate("October", 5, -2023); // Invalid negative year
        assertEquals("Should remain unchanged after setting negative year", before, bob);
    }
}

