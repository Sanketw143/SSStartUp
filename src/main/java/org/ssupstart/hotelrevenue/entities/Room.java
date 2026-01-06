package org.ssupstart.hotelrevenue.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Room {
    private String roomId;
    private String roomType;
    private int capacity;
    private List<Booking> bookings = new ArrayList<>();

    public Room(String roomId, String roomType, int capacity) {
        this.roomId = roomId;
        this.roomType = roomType;
        this.capacity = capacity;
    }

    public void addBooking(Booking b1) {
        bookings.add(b1);
    }
}
