package org.acme.web;

import org.acme.dto.Flight;
import org.acme.dto.Reservation;
import org.acme.service.FlightService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Path("/flights")
public class FlightResource {
    @Inject
    private FlightService service;
    private List<Reservation> reservations = new ArrayList<>();

    @GET
    public Set<Flight> getFlights() {
        return service.getFlights();
    }

    @GET
    @Path("/{flightNumber}")
    public Flight getFlight(@PathParam("flightNumber") int flightNumber) {
        System.out.println(flightNumber);
        Optional<Flight> flight = service.getFlights().stream()
                .filter(object -> object.getNumber() == flightNumber)
                .findFirst();
        if (flight.isPresent()) {
            return flight.get();
        }
        return null;
    }

    @POST
    public Response createFlight(Flight flight) {
        Optional<Flight> existingFlight = service.getFlights().stream()
                .filter(f -> f.getNumber() == flight.getNumber())
                .findFirst();

        if (existingFlight.isPresent()) {
            Flight existing = existingFlight.get();
            if (existing.getAvailableSeats() > 0) {
                existing.setAvailableSeats(existing.getAvailableSeats() - 1);
                return Response.status(Response.Status.CREATED).build();
            } else {
                return Response.status(Response.Status.CONFLICT).entity("No available seats").build();
            }
        } else {
            service.getFlights().add(flight);
            flight.setAvailableSeats(flight.getAvailableSeats() - 1);
            return Response.status(Response.Status.CREATED).build();
        }
    }
}