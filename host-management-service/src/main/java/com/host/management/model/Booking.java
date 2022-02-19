package com.host.management.model;

import java.util.Date;

public class Booking {
    private int bookingID;
    private String email;
    private Date bookingDate;
    private Host host;

    public int getBookingID() {
        return bookingID;
    }

    public void setBookingID(int bookingID) {
        this.bookingID = bookingID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(Date bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Host getHost() {
        return host;
    }

    public void setHost(Host host) {
        this.host = host;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingID=" + bookingID +
                ", email='" + email + '\'' +
                ", bookingDate=" + bookingDate +
                ", host=" + host +
                '}';
    }
}
