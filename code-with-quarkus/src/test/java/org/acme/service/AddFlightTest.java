package org.acme.resource;
import org.acme.main.Flight;
import org.acme.service.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;
import java.util.Set;

public class AddFlightTest {

    private FlightResource flightResource;

    @BeforeEach
    public void setup() {
        flightResource = new FlightResource();
        flightResource.service = new FlightService();
    }

    @Test
    public void testCreateFlightWithAvailableSeats() {

        Flight flight = new Flight(4, "London", "Madrid", "01.08.2023", 10);


        Response response = flightResource.createFlight(flight);


        Assertions.assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());

        Set<Flight> flights = flightResource.getFlights();
        Assertions.assertTrue(flights.contains(flight));

        Flight createdFlight = flights.stream()
                .filter(f -> f.getNumber() == flight.getNumber())
                .findFirst()
                .orElse(null);

        Assertions.assertNotNull(createdFlight);
        Assertions.assertEquals(9, createdFlight.getAvailableSeats());
    }

    @Test
    public void testCreateFlightWithNoAvailableSeats() {

        Flight flight = new Flight(1, "Praga", "Łódź", "30.07.2023", 0);


        Response response = flightResource.createFlight(flight);


        Assertions.assertEquals(Response.Status.CONFLICT.getStatusCode(), response.getStatus());

        Set<Flight> flights = flightResource.getFlights();
        Assertions.assertFalse(flights.contains(flight));
    }
}
