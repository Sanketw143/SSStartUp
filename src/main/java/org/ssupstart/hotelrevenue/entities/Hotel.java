package org.ssupstart.hotelrevenue.entities;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class Hotel {
    private String hotelId;
    private String name;
    private List<Room> rooms = new ArrayList<>();

    public Hotel(String hotelId, String name) {
        this.hotelId = hotelId;
        this.name = name;
    }

    public void addRoom(Room r1) {
        rooms.add(r1);
    }
}
