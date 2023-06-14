package org.acme.service;

import org.acme.main.Flight;
import org.acme.main.Reservation;

import javax.inject.Singleton;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Optional;
import java.util.Set;

@Singleton
public class FlightService {
    private Set<Flight> flights = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public FlightService() {
        flights.add(new Flight(3, "Warszawa", "Berlin", "25.06.2023", 20));
        flights.add(new Flight(2, "Berlin", "Paryż", "20.06.2023", 19));
        flights.add(new Flight(1, "Praga", "Łódź", "30.07.2023", 0));
    }

    public boolean commitReservation(Reservation reservation) {
        Optional<Flight> existingFlight = flights.stream()
                .filter(f -> f.getNumber() == reservation.getFlightNumber())
                .findFirst();


        if (existingFlight.isPresent()) {
            Flight existing = existingFlight.get();
            if (existing.getAvailableSeats() > 0) {
                existing.setAvailableSeats(existing.getAvailableSeats() - 1);
                return true;
            } else {
                System.out.println("No seats available");
                return false;
            }
        } else {
            return false;
        }
    }


    public Set<Flight> getFlights() {
        return flights;
    }
}
