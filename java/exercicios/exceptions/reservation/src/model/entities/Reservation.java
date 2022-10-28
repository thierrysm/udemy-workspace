package model.entities;

import model.exceptions.DomainException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {

    DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private  Integer roomNumber;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(Integer roomNumber, LocalDate checkIn, LocalDate checkOut) {
        if (checkOut.isBefore(checkIn)) {
            throw new DomainException ("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalDate checkIn) {
        this.checkIn = checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalDate checkOut) {
        this.checkOut = checkOut;
    }

    public long duration () {
        long dias = checkIn.until(checkOut, ChronoUnit.DAYS);
        return dias;
    }

    public void updateDates (LocalDate checkIn, LocalDate checkOut) {
        if (checkOut.isBefore(checkIn)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date");
        }
        if (checkIn.isBefore(getCheckOut())) {
            throw new DomainException("Error in reservation: Reservation dates for update must be future dates");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString () {
        return "Reservation: Room " + getRoomNumber()
                + ", check-in: " + getCheckIn().format(dtf1)
                + ", check-out " + getCheckOut().format(dtf1)
                + ", " + duration() + " nights";
    }
}
