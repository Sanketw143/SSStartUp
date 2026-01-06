package org.ssupstart.hotelrevenue.entities;

import lombok.Data;

import java.time.LocalDate;


@Data
public class Booking {
    private String bookingId;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double pricePerNight;

    public Booking(String bookingId, LocalDate checkIn, LocalDate checkOut, double pricePerNight) {
        this.bookingId = bookingId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.pricePerNight = pricePerNight;
    }
}
