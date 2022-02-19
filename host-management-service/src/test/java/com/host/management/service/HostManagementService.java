package com.host.management.service;

import com.host.management.model.Host;
import com.host.management.util.Util;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class HostManagementService {

    public Boolean isHostAvailable(int hostID, Date bookingDate) {
        return Util.getHostLibrary().stream()
                .filter(hst -> hst.getHostID() == hostID && hst.getAvailability().get(bookingDate).equals(true))
                .count() > 1l;
    }

    public Host placeBooking(int hostID, Date bookingDate) {
        Optional<Host> host = Util.getHostLibrary().stream()
                .filter(hst -> hst.getHostID() == hostID)
                .findFirst();

        if(host.isPresent()){
            host.get().getAvailability().put(bookingDate, false);
        }

        return host.get();
    }
}
