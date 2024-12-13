package model.entities;

import model.exceptions.DomainException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
    private Integer room;
    private LocalDate checkIn;
    private LocalDate checkOut;

    public Reservation(){}

    public Reservation(Integer room, LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now(); // Evita múltiplas chamadas a LocalDate.now()
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Error in reservation: Reservation dates must be future dates.");
        }
        if (checkIn.isAfter(checkOut)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date.");
        }
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public long duration(){
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public void updateDates(LocalDate checkIn, LocalDate checkOut) {
        LocalDate now = LocalDate.now();
        if (checkIn.isBefore(now) || checkOut.isBefore(now)) {
            throw new DomainException("Error in reservation: Reservation dates must be future dates.");
        }
        if (checkIn.isAfter(checkOut)) {
            throw new DomainException("Error in reservation: Check-out date must be after check-in date.");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }


    @Override
    public String toString(){
        return "Reservation: Room "
                + getRoom()
                + ", check-in: "
                + getCheckIn().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + ", check-out: "
                + getCheckOut().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
                + " "
                + duration()
                + " nights.";
    }
}
