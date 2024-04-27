package com.genie.HotelMgmt.Aop;

import com.genie.HotelMgmt.entity.Bookings;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Aspect
public class LoggingAspect {

   /* @Before("execution(* com.genie.HotelMgmt.controller.BookingController.getAllBooking())")
    public void logBeforeGetAllBooking(JoinPoint joinPoint) {
        System.out.println("Before executing getAllBooking() method...");
    }

    @AfterReturning(pointcut = "execution(* com.genie.HotelMgmt.controller.BookingController.getAllBooking())", returning = "bookings")
    public void logAfterGetAllBooking(JoinPoint joinPoint, List<Bookings> bookings) {
        System.out.println("After executing getAllBooking() method...");
        System.out.println("Returned bookings: " + bookings);
    }*/

    @Pointcut("execution(* com.genie.HotelMgmt.controller.BookingController.getAllBooking())")
    public void getBookingAllPointCut()
    {
    }

    @Before("getBookingAllPointCut()")
    public void logBeforeGetAllBooking(JoinPoint joinPoint) {
        System.out.println("Before executing getAllBooking() method...");
        String name = joinPoint.getSignature().getName();
        System.out.println("Method name for JP : ===>"+name);
    }

    @AfterReturning(pointcut = "getBookingAllPointCut()", returning = "bookings")
    public void logAfterGetAllBooking(JoinPoint joinPoint, List<Bookings> bookings) {
        System.out.println("After executing getAllBooking() method...");
        System.out.println("Returned bookings: " + bookings);
    }
}
