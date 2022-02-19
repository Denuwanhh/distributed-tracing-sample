package com.host.management.model;

import java.util.Date;
import java.util.Map;

public class Host {
    private int hostID;
    private String address;
    private Map<String, Boolean> availability;

    public Host(int hostID, String address, Map<String, Boolean> availability) {
        this.hostID = hostID;
        this.address = address;
        this.availability = availability;
    }

    public int getHostID() {
        return hostID;
    }

    public void setHostID(int hostID) {
        this.hostID = hostID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Map<String, Boolean> getAvailability() {
        return availability;
    }

    public void setAvailability(Map<String, Boolean> availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Host{" +
                "hostID=" + hostID +
                ", address='" + address + '\'' +
                '}';
    }
}
