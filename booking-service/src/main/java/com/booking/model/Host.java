package com.booking.model;

public class Host {
    private int hostID;
    private String address;

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

    @Override
    public String toString() {
        return "Host{" +
                "hostID=" + hostID +
                ", address='" + address + '\'' +
                '}';
    }
}
