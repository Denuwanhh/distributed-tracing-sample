package com.host.management.service;

import com.host.management.model.Host;
import com.host.management.util.Util;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HostManagementService {

    public Boolean isHostAvailable(int hostID, Date checkingDate){
        return Util.getHostLibrary().stream()
                .filter(hst -> hst.getHostID() == hostID && hst.getAvailability().get(checkingDate).equals(true))
                .count() > 1l;
    }
}
