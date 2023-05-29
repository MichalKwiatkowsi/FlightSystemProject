package org.acme.service;

import org.acme.dto.Reservation;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

class FlightServiceTest {
    //@MockBean(FlightService)
    // FlightService flightService() {
      //  Mock(FlightService);
    //}
//    @Inject
//    FlightService service;
    @Test
    void commitReservation(FlightService service) {
        //given:
        Reservation reservation = new Reservation(1,"Kamil Nowak");

        //when:
        boolean result = service.commitReservation(reservation);
        //then:
        assertTrue(result);
    }
}