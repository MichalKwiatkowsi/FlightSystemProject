package org.acme.dto;

public class Flight {

    int number;
    String origin;
    String destination;
    String date;
    int availableSeats;
    String passengerName;

    public Flight() {

    }

    public Flight(int number, String origin, String destination, String date, int availableSeats) {
        this.number = number;
        this.origin = origin;
        this.destination = destination;
        this.date = date;
        this.availableSeats = availableSeats;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }


}


