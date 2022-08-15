package com.navi.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Vehicle {
    String vehicleType;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(Integer ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    String name;
    Integer ratePerHour;
    List<Booking> bookings;
    public Vehicle(String vehicleType, String name, String rate){
        this.vehicleType = vehicleType;
        this.name = name;
        this.ratePerHour = Integer.parseInt(rate);
        this.bookings = new ArrayList<>();
    }
    public void bookFrom(Integer start, Integer end){
        bookings.add(new Booking(start, end));
    }

    boolean isBookedBetween(int start, int end){
        bookings.sort(Comparator.comparingInt(Booking::getStart));
        for(Booking booking: bookings){
            if((start >= booking.getStart() && start <= booking.getEnd()) || (end >= booking.getStart() && end <= booking.getEnd()))
                return true;
        }
        return false;
    }
}
