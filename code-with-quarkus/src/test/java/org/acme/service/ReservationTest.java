package org.acme.service;

import org.acme.main.Flight;
import org.acme.main.Reservation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

public class ReservationTest {

    private FlightService flightService;

    @BeforeEach
    public void setup() {
        flightService = new FlightService();
    }

    @Test
    public void testCommitReservationWithAvailableSeats() {

        Reservation reservation = new Reservation(3, "John Doe");


        boolean result = flightService.commitReservation(reservation);


        Assertions.assertTrue(result);

        Set<Flight> flights = flightService.getFlights();
        Flight flight = flights.stream()
                .filter(f -> f.getNumber() == reservation.getFlightNumber())
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(flight);
        Assertions.assertEquals(19, flight.getAvailableSeats());
    }

    @Test
    public void testCommitReservationWithNoAvailableSeats() {

        Reservation reservation = new Reservation(1, "Jane Smith");


        boolean result = flightService.commitReservation(reservation);


        Assertions.assertFalse(result);

        Set<Flight> flights = flightService.getFlights();
        Flight flight = flights.stream()
                .filter(f -> f.getNumber() == reservation.getFlightNumber())
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(flight);
        Assertions.assertEquals(0, flight.getAvailableSeats());
    }
}
