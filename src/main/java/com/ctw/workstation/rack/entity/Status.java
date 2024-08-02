package com.ctw.workstation.rack.entity;



public enum Status {

    AVAILABLE, UNAVAILABLE, BOOKED;

    public static Status stringToUpperCase(String status){
        return Status.valueOf(status.toUpperCase());
    }
}
