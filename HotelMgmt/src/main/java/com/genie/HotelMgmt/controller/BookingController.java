package com.genie.HotelMgmt.controller;

import com.genie.HotelMgmt.service.BookingService;
import com.genie.HotelMgmt.dto.BookingDTO;

import com.genie.HotelMgmt.entity.Bookings;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/create")
    public Bookings createBooking(@RequestBody BookingDTO bookingDTO) {
        return bookingService.createBooking(bookingDTO);
    }

    @GetMapping("/checkOverlap")
    public boolean checkOverlap(
            @RequestParam String roomNumber,
            @RequestParam String startTime, // Parse as String
            @RequestParam String endTime     // Parse as String
    ) {
        LocalDateTime startDateTime = LocalDateTime.parse(startTime);
        LocalDateTime endDateTime = LocalDateTime.parse(endTime);

        List<Bookings> overlappingBookings = bookingService.findOverlappingBookings(roomNumber, startDateTime, endDateTime);
        return !overlappingBookings.isEmpty();
    }

    @GetMapping("/all-bookings")
    public List<Bookings> getAllBooking()
    {
       //System.out.println("before executing getAllBooking controller");
        return bookingService.getAllBooking();
    }
}
