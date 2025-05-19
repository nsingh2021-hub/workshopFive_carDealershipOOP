package com.ps;

public abstract class Contract {
    protected String name;
    protected String email;
    protected Vehicle vehicle;

    public Contract(String name, String email, Vehicle vehicle) {
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
    }

    public abstract String getContractDetails();
    public abstract Vehicle getVehicleSold();
}