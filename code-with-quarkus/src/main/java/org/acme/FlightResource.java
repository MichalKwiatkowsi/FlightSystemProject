package org.acme;

import org.jboss.resteasy.annotations.Body;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/flights")
public class FlightResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Flight getFlights()
    {
        Flight flight = new Flight(3);
        return flight;
    }
    @GET
    @Path("/1")
    @Produces(MediaType.APPLICATION_JSON)
    public String getFlight() {
        return "This is get method";
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createFlight(Flight flight)
    {
        System.out.println(flight);
        return "This is post method";
    }

}