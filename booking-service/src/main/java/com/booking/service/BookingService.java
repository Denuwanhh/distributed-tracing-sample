package com.booking.service;

import com.booking.model.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

@Service
public class BookingService {

    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private RestTemplate restTemplate;

    public Boolean placeBooking(Booking booking) {

        logger.info("[Dev] New booking : " + booking);

        return true;
    }
}
