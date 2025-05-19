package com.ps;

public class LeaseContract extends Contract {

    public LeaseContract(String name, String email, Vehicle vehicle) {
        super(name, email, vehicle);
    }

    @Override
    public String getContractDetails() {
        return "Lease Contract: Name: " + name + ", Email: " + email + ", Vehicle: " + vehicle.getMake() + " " + vehicle.getModel();
    }

    @Override
    public Vehicle getVehicleSold() {
        return vehicle;
    }
}

