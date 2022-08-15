package com.navi.model.comparator;

import com.navi.model.Vehicle;

import java.util.Comparator;

public class VehicleComparator implements Comparator<Vehicle> {

    // Overriding compare() method of Comparator
    public int compare(Vehicle v1, Vehicle v2) {
        return Integer.compare(v1.getRatePerHour(), v2.getRatePerHour());
    }
}
