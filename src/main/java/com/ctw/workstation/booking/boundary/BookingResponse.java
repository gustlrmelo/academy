package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.rack.entity.Status;

import java.util.UUID;

public class BookingResponse {
    private UUID bookingId;
    private String rackSerialNumber;
    private String requesterName;
    private String teamName;
    private Status status;

    public BookingResponse(UUID bookingId, String rackSerialNumber, String requesterName, String teamName, Status status) {
        this.bookingId = bookingId;
        this.rackSerialNumber = rackSerialNumber;
        this.requesterName = requesterName;
        this.teamName = teamName;
        this.status = status;
    }

    public UUID getBookingId() {
        return bookingId;
    }

    public void setBookingId(UUID bookingId) {
        this.bookingId = bookingId;
    }

    public String getRackSerialNumber() {
        return rackSerialNumber;
    }

    public void setRackSerialNumber(String rackSerialNumber) {
        this.rackSerialNumber = rackSerialNumber;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public void setRequesterName(String requesterName) {
        this.requesterName = requesterName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
