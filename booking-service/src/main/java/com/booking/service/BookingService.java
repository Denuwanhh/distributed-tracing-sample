package com.booking.service;

import com.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Date;

@Service
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private RestTemplate restTemplate;

    public Boolean placeBooking(Booking booking) {

        logger.info("[Dev] New booking : " + booking);

        return checkAvailability(1, new Date());
    }

    private boolean checkAvailability(int hostID, Date bookingDate){

        logger.info("[Dev] Check Availability Request: [Host ID" + hostID + " [Booking Date]" + bookingDate);

        URI uri = URI.create("http://localhost:8081/check-availability");
        ResponseEntity<Boolean> response
                = restTemplate.getForEntity(uri + "?host=" + hostID + "&date=" + bookingDate , Boolean.class);

        logger.info("[Dev] Check Availability Response:" + response);

        return response.getBody();
    }

}
