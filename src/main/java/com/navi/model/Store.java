package com.navi.model;

import java.util.HashMap;

public class Store {
    HashMap<String, Branch> branches = new HashMap<>();

    public boolean addBranch(String branch, String VehicleTypes) {
        if(!branches.containsKey(branch)){
            branches.put(branch, new Branch());
        }

        branches.get(branch).addVehicleTypes(VehicleTypes);
        return true;
    }

    public boolean addVehicle(String branch, String vehicleType, String name, String costPerHour){
        if(!branches.containsKey(branch))
            return false;

        return branches.get(branch).addVehicleToBranch(new Vehicle(vehicleType, name, costPerHour));
    }

    public int bookVehicle(String branch, String vehicleType, String startTime, String endTime){
        if(!branches.containsKey(branch))
            return -1;

        int start = Integer.parseInt(startTime);
        int end = Integer.parseInt(endTime);
        return branches.get(branch).bookVehicleFromBranch(vehicleType, start, end);
    }

    public String displayVehicles(String branch, String startTime, String endTime){
        if(!branches.containsKey(branch))
            return "";

        int start = Integer.parseInt(startTime);
        int end = Integer.parseInt(endTime);
        return branches.get(branch).displayAvailableVehicles(start, end);
    }
}
