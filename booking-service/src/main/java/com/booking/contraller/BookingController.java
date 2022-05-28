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

    @GetMapping
    public String getServiceDetails(@RequestParam(name = "level", required = false, defaultValue = "N/A") String level, @RequestParam(name = "format", required = false, defaultValue = "NL") String format, @RequestHeader(name = "requested-by", required = false, defaultValue = "N/A") String requestedBy){
        return bookingService.getServiceDetails(level, format, requestedBy);
    }

    @PostMapping
    public Boolean placeBooking(@RequestBody Booking booking){
        return bookingService.placeBooking(booking);
    }

}
