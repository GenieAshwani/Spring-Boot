package com.genie.HotelMgmt.service;

import com.genie.HotelMgmt.dto.BookingDTO;
import com.genie.HotelMgmt.entity.Bookings;
import com.genie.HotelMgmt.entity.RoomType;
import com.genie.HotelMgmt.repo.BookingRepository;
import com.genie.HotelMgmt.repo.RoomTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    private BookingRepository bookingRepository;

    @Autowired
    private RoomTypeRepository roomTypeRepository;

    public static int A=2;
    public static int B=3;
    public static int C=5;

    public Bookings createBooking(BookingDTO bookingDTO) {
        // Convert BookingDTO to Booking entity
        Bookings booking = new Bookings();
        booking.setUserEmail(bookingDTO.getUserEmail());
        booking.setRoomNumber(bookingDTO.getRoomNo());
        booking.setStartTime(bookingDTO.getStartTime());
        booking.setEndTime(bookingDTO.getEndTime());
        RoomType roomType = roomTypeRepository.findByName(bookingDTO.getRoomType());
        String type=roomType.getName();
        booking.setRoomType(roomType);

        // Calculate price based on room type's price per hour
        Double durationHours = calculateDurationHours(booking.getStartTime(), booking.getEndTime());
        Double totalPrice = durationHours * booking.getRoomType().getPricePerHour();
        booking.setPrice(totalPrice);

        Long roomTypeId = roomType.getId();
        List<Bookings> allBookingbyType = bookingRepository.findAllBookingbyType(roomTypeId);
        // Save booking to database
        if(type.equalsIgnoreCase("A") && allBookingbyType.size()<2)
        {
            return bookingRepository.save(booking);
        }
        else if(type.equalsIgnoreCase("B") && allBookingbyType.size()<3)
        {
            return bookingRepository.save(booking);
        }
        else if(type.equalsIgnoreCase("C") && allBookingbyType.size()<5)
        {
            return bookingRepository.save(booking);
        }


        throw new RuntimeException("Rooms Are full");
    }

    private Double calculateDurationHours(LocalDateTime startTime, LocalDateTime endTime) {
        return (double) Duration.between(startTime, endTime).toHours();
    }

    public List<Bookings> findOverlappingBookings(String roomNumber, LocalDateTime startTime, LocalDateTime endTime) {
        return bookingRepository.findOverlappingBookings(roomNumber, startTime, endTime);
    }

    public List<Bookings> getAllBooking() {

         return bookingRepository.findAll();
    }
}