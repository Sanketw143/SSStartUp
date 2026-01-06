package org.ssupstart.hotelrevenue.service;

import org.springframework.stereotype.Service;
import org.ssupstart.hotelrevenue.entities.Booking;
import org.ssupstart.hotelrevenue.entities.Hotel;
import org.ssupstart.hotelrevenue.entities.Room;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
public class HotelAnalyzer {

    public static void main(String[] args) {
        Hotel hotel = new Hotel("H101", "Blue Lagoon Resort");

        Room r1 = new Room("R1", "Deluxe", 2);
        Room r2 = new Room("R2", "Standard", 2);
        Room r3 = new Room("R3", "Suite", 4);

        r1.addBooking(new Booking("B1", LocalDate.of(2025, 10, 10),
                               LocalDate.of(2025, 10, 13), 5000));
        r1.addBooking(new Booking("B2", LocalDate.of(2025, 10, 20),
                               LocalDate.of(2025, 10, 22), 5500));
        r2.addBooking(new Booking("B3", LocalDate.of(2025, 10, 11),
                               LocalDate.of(2025, 10, 14), 3000));
        r3.addBooking(new Booking("B4", LocalDate.of(2025, 10, 9),
                               LocalDate.of(2025, 10, 12), 10000));

        hotel.addRoom(r1);
        hotel.addRoom(r2);
        hotel.addRoom(r3);

        getRevenue(hotel);

    }

    private static void getRevenue(Hotel hotel) {
        Room maxRevenueRoom = null;
        Double maxRevenue = 0D;
        Map<Room,Double> roomAndRevenueMap = new HashMap<>();
        List<Room> rooms = hotel.getRooms();
        for (Room room : rooms) {
            List<Booking> bookings = room.getBookings();
            for (Booking booking : bookings) {
                Period result = Period.between(booking.getCheckIn(), booking.getCheckOut());
                int numberOfNights = result.getDays();
                Double currentBookingRevenue =0D;
                currentBookingRevenue = numberOfNights * booking.getPricePerNight();
                if(Objects.nonNull(roomAndRevenueMap.get(room))) {
                    Double existingRevenueOfRoom = roomAndRevenueMap.get(room);
                    Double finalRevenue = currentBookingRevenue + existingRevenueOfRoom;
                    roomAndRevenueMap.put(room, finalRevenue);
                    maxRevenue = Math.max(finalRevenue, maxRevenue);
                } else {
                    roomAndRevenueMap.put(room, currentBookingRevenue);
                    maxRevenue = Math.max(currentBookingRevenue, maxRevenue);
                }

            }
        }
        System.out.println(maxRevenue);
    }
    //Implement the following methods in a class called HotelAnalyzer:
//Find the room with the highest total revenue
//Total revenue = sum of (number of nights × pricePerNight)
// for all bookings in that room
//
}
