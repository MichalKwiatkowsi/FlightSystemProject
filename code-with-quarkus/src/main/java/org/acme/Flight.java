package org.acme;

public class Flight {
    int number;

    public Flight() {

    }

    public Flight(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "number=" + number +
                '}';
    }

}
