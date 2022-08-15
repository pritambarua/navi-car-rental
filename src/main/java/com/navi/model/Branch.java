package com.navi.model;


import com.navi.model.comparator.VehicleComparator;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Branch {
    public Map<String, PriorityQueue<Vehicle>> getVehicleTypes() {
        return vehicleTypes;
    }

    public Integer getTotalCars() {
        return totalCars;
    }

    public void setTotalCars(Integer totalCars) {
        this.totalCars = totalCars;
    }

    private final Map<String, PriorityQueue<Vehicle>> vehicleTypes = new HashMap<>();
    private Integer totalCars = 0;
    private void addVehicleType(String vehicle){
        if(vehicleTypes.containsKey(vehicle)){
            return;
        }

        vehicleTypes.put(vehicle, new PriorityQueue<>(new VehicleComparator()));
    }

    public void addVehicleTypes(String vehicleTypes){
        String[] vehicleTypesSeperatedBySpaces = vehicleTypes.split(",");
        for (String vehicleType: vehicleTypesSeperatedBySpaces)
            addVehicleType(vehicleType);
    }

    public boolean addVehicleToBranch(Vehicle vehicle){
        if(!vehicleTypes.containsKey((vehicle.vehicleType)))
            return  false;

        vehicleTypes.get(vehicle.vehicleType).add(vehicle);
        ++totalCars;
        return true;
    }

    public int bookVehicleFromBranch(String VehicleType, int start, int end){
        if(!vehicleTypes.containsKey(VehicleType))
            return -1;

        var listOfVehicles = vehicleTypes.get(VehicleType);
        for(Vehicle vehicle : listOfVehicles){
            if(!vehicle.isBookedBetween(start, end)){
                vehicle.bookFrom(start, end);
                return vehicle.ratePerHour * (end - start);
            }
        }
        return -1;
    }

    private double demandFactor(int totalBooked){
        boolean overDemand = (totalCars - totalBooked) * 1.0 / totalCars > 0.8;
        return overDemand ? 1.1 : 1;
    }

    public String displayAvailableVehicles(int start, int end){
        StringBuilder ans = new StringBuilder();
        for(var listOfVehicles: vehicleTypes.keySet()){
            for(Vehicle vehicle: vehicleTypes.get(listOfVehicles)){
                if(!vehicle.isBookedBetween(start, end)){
                    ans.append(vehicle.name).append(',');
                }
            }
        }
        return ans.substring(0, ans.length()-1);
    }

}
