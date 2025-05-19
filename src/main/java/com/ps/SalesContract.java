package com.ps;


public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(String name, String email, Vehicle vehicle, boolean isFinanced) {
        super(name, email, vehicle);
        this.isFinanced = isFinanced;
    }

    @Override
    public String getContractDetails() {
        return "Sales Contract: Name: " + name + ", Email: " + email + ", Vehicle: " + vehicle.getMake() + " " + vehicle.getModel() + ", Financed: " + (isFinanced ? "Yes" : "No");
    }

    @Override
    public Vehicle getVehicleSold() {
        return vehicle;
    }
}





