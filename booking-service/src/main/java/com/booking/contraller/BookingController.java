package com.booking.contraller;

import com.booking.model.Booking;
import com.booking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public Boolean placeBooking(@RequestBody Booking booking){
        return bookingService.placeBooking(booking);
    }

}
