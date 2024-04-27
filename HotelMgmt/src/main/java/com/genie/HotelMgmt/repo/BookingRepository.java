package com.genie.HotelMgmt.repo;

import com.genie.HotelMgmt.entity.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
   @Query(value = "select * from bookings where room_type_id=:roomTypeId", nativeQuery = true)
   List<Bookings> findAllBookingbyType(@Param("roomTypeId") Long roomTypeId);

   @Query("SELECT b FROM Bookings b WHERE b.roomNumber = :roomNumber " +
           "AND ((b.startTime BETWEEN :startTime AND :endTime) " +
           "OR (b.endTime BETWEEN :startTime AND :endTime))")
   List<Bookings> findOverlappingBookings(
           @Param("roomNumber") String roomNumber,
           @Param("startTime") LocalDateTime startTime,
           @Param("endTime") LocalDateTime endTime
   );
}
