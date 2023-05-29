package org.acme.dto;

public class Reservation {
    private int flightNumber;
    private String passengerName;

    public Reservation() {
    }

    public Reservation(int flightNumber, String passengerName) {
        this.flightNumber = flightNumber;
        this.passengerName = passengerName;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }
}
