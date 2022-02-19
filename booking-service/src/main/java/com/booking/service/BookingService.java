package com.booking.service;

import com.booking.model.Booking;
import com.booking.model.Host;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private RestTemplate restTemplate;

    public Boolean placeBooking(Booking booking) {

        logger.info("[Dev] New booking : " + booking);
        Boolean isBookingSuccess = false;

        if (checkAvailability(booking.getHost().getHostID(), booking.getBookingDate())) {
            isBookingSuccess = bookingHost(booking);
        }

        return isBookingSuccess;
    }

    private boolean bookingHost(Booking booking) {
        logger.info("[Dev] Booking Host Request: [Booking] " + booking);

        URI uri = URI.create("http://localhost:8081/host-management/booking");
        HttpEntity<Booking> request = new HttpEntity<>(booking);

        ResponseEntity<Host> response
                = restTemplate.postForEntity(uri, request, Host.class);

        logger.info("[Dev] Booking Host Response:" + response);

        return response.getBody() != null;
    }

    private boolean checkAvailability(int hostID, Date bookingDate) {

        logger.info("[Dev] Check Availability Request: [Host ID] " + hostID + " [Booking Date] " + bookingDate);

        URI uri = URI.create("http://localhost:8081/host-management/check-availability");
        ResponseEntity<Boolean> response
                = restTemplate.getForEntity(uri + "?host=" + hostID + "&date=" + new SimpleDateFormat("yyyy-MM-dd").format(bookingDate), Boolean.class);

        logger.info("[Dev] Check Availability Response:" + response);

        return response.getBody();
    }

}
