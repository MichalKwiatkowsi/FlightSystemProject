package org.acme.resource;

import org.acme.main.Reservation;
import org.acme.service.FlightService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/reservations")
public class ReservationResource {

    private Set<Reservation> reservations = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    @Inject
    public FlightService service;

    @POST
    public Response createReservation(Reservation reservation) {
        boolean commited =service.commitReservation(reservation);
        if (commited) {
            reservations.add(reservation);

            return Response.status(Response.Status.CREATED).build();
        } else {
            return Response.status(Response.Status.CONFLICT).entity("No available seats").build();
        }
    }

    @GET
    public Set<Reservation> getReservations() {
        return reservations;
    }
}