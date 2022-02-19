package com.host.management.contraller;

import com.host.management.model.Booking;
import com.host.management.model.Host;
import com.host.management.service.HostManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("host-management")
public class HostManagementController {

    @Autowired
    private HostManagementService hostManagementService;

    @GetMapping(value = "/check-availability")
    public Boolean checkHostAvailability(@RequestParam("host") int hostID, @RequestParam("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date bookingDate) {
        return hostManagementService.isHostAvailable(hostID, bookingDate);
    }

    @PostMapping(value = "/booking")
    public Host bookHost(@RequestBody Booking booking) {
        return hostManagementService.placeBooking(booking.getHost().getHostID(), booking.getBookingDate());
    }
}