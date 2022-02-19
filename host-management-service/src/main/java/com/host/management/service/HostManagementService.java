package com.host.management.service;

import com.host.management.model.Host;
import com.host.management.util.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class HostManagementService {

    private static final Logger logger = LoggerFactory.getLogger(HostManagementService.class);

    public Boolean isHostAvailable(int hostID, Date bookingDate) {

        logger.info("[Dev] Check the host availability " + hostID + "/" + bookingDate);

        return Util.getHostLibrary().stream()
                .filter(hst -> hst.getHostID() == hostID && (hst.getAvailability().get(new SimpleDateFormat("yyyyMMdd").format(bookingDate)) == null || hst.getAvailability().get(new SimpleDateFormat("yyyyMMdd").format(bookingDate)).equals(true)) )
                .count() > 0l;
    }

    public Host placeBooking(int hostID, Date bookingDate) {

        logger.info("[Dev] Place Booking " + hostID + "/" + bookingDate);

        Optional<Host> host = Util.getHostLibrary().stream()
                .filter(hst -> hst.getHostID() == hostID)
                .findFirst();

        if(host.isPresent()){
            logger.info("[Dev] Host available & placing the booking [Host ID]" + hostID);
            host.get().getAvailability().put(new SimpleDateFormat("yyyyMMdd").format(bookingDate), false);
        }else{
            logger.info("[Dev] Host not available [Host ID]" + hostID);
        }

        return host.get();
    }
}
