package com.booking.model;

import java.util.Date;

public class Booking {
    private int bookingID;
    private String email;
    private Date checkingDate;
    private Date checkoutDate;
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

    public Date getCheckingDate() {
        return checkingDate;
    }

    public void setCheckingDate(Date checkingDate) {
        this.checkingDate = checkingDate;
    }

    public Date getCheckoutDate() {
        return checkoutDate;
    }

    public void setCheckoutDate(Date checkoutDate) {
        this.checkoutDate = checkoutDate;
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
                ", checkingDate=" + checkingDate +
                ", checkoutDate=" + checkoutDate +
                ", host=" + host +
                '}';
    }
}
