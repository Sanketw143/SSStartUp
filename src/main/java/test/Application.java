package test;

//Problem: Hotel Room Booking & Revenue Analyzer
//Problem Description
//You are designing a system for hotel room management and revenue analysis.
//Each hotel has multiple rooms of different types (e.g., Standard, Deluxe, Suite).
//Each room type can have multiple bookings, and each booking has:
//checkInDate
//        checkOutDate
//pricePerNight
//You must analyze the data to answer key business questions.
//
//Classes to Create
//        Booking
//String bookingId
//LocalDate checkIn
//LocalDate checkOut
//double pricePerNight
//Room
//String roomId
//String roomType
//int capacity (number of guests it can hold)
//List<Booking> bookings
//Hotel
//String hotelId
//String name
//List<Room> rooms
//
//Tasks
//Implement the following methods in a class called HotelAnalyzer:
//Find the room with the highest total revenue
//Total revenue = sum of (number of nights × pricePerNight) for all bookings in that room
//
//Example Input
//
//Hotel h = new Hotel("H101", "Blue Lagoon Resort");
//
//Room r1 = new Room("R1", "Deluxe", 2);
//Room r2 = new Room("R2", "Standard", 2);
//Room r3 = new Room("R3", "Suite", 4);
//
//r1.addBooking(new Booking("B1", LocalDate.of(2025, 10, 10),
//                               LocalDate.of(2025, 10, 13), 5000));
//        r1.addBooking(new Booking("B2", LocalDate.of(2025, 10, 20),
//                               LocalDate.of(2025, 10, 22), 5500));
//        r2.addBooking(new Booking("B3", LocalDate.of(2025, 10, 11),
//                               LocalDate.of(2025, 10, 14), 3000));
//        r3.addBooking(new Booking("B4", LocalDate.of(2025, 10, 9),
//                               LocalDate.of(2025, 10, 12), 8000));
//
//        h.addRoom(r1);
//h.addRoom(r2);
//h.addRoom(r3);
//
//Expected Output
//
//Highest revenue room: R1 (Total: 26000.0)
public class Application {
}
