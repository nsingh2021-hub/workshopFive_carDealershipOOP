package com.ps;

import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;
    private Scanner scanner = new Scanner(System.in);

    private void init(){
        dealership = DealershipFileManager.getDealership();
    }

    public UserInterface(){
        init();
    }

    public void display(){
        System.out.println("Welcome to the dealership program");
        int mainMenuCommand;
        do{
            System.out.println("1. Get by price");
            System.out.println("2. Get by make/model");
            System.out.println("3. Get by year");
            System.out.println("4. Get by color");
            System.out.println("5. Get by mileage");
            System.out.println("6. Get by type");
            System.out.println("7. Get all");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("0. Exit");

            System.out.print("Command: ");
            mainMenuCommand = scanner.nextInt();

            switch(mainMenuCommand){
                case 1: processGetByPriceRequest(); break;
                case 2: processGetByMakeModelRequest(); break;
                case 3: processGetByYearRequest(); break;
                case 4: processGetByColorRequest(); break;
                case 5: processGetByMileageRequest(); break;
                case 6: processGetByVehicleTypeRequest(); break;
                case 7: processGetAllVehiclesRequest(); break;
                case 8: processAddVehicleRequest(); break;
                case 9: processRemoveVehicleRequest(); break;
                case 0: System.out.println("Exiting..."); break;
                default: System.out.println("Command not found, try again");
            }
        } while(mainMenuCommand != 0);
    }

    private void processGetByPriceRequest(){
        System.out.println("--------Display vehicles by price--------");
        System.out.print("Min: ");
        double min = scanner.nextDouble();
        System.out.print("Max: ");
        double max = scanner.nextDouble();
        displayVehicles(dealership.vehiclesByPrice(min, max));
    }

    private void processGetByMakeModelRequest(){
        System.out.println("--------Display vehicles by make and model--------");
        System.out.print("Make: ");
        String make = scanner.next();
        System.out.print("Model: ");
        String model = scanner.next();
        displayVehicles(dealership.vehiclesByMakeModel(make, model));
    }

    private void processGetByYearRequest(){
        System.out.println("--------Display vehicles by year--------");
        System.out.print("Min year: ");
        int min = scanner.nextInt();
        System.out.print("Max year: ");
        int max = scanner.nextInt();
        displayVehicles(dealership.vehiclesByYear(min, max));
    }

    private void processGetByColorRequest(){
        System.out.println("--------Display vehicles by color--------");
        System.out.print("Color: ");
        String color = scanner.next();
        displayVehicles(dealership.vehiclesByColor(color));
    }

    private void processGetByMileageRequest(){
        System.out.println("--------Display vehicles by mileage--------");
        System.out.print("Min: ");
        int min = scanner.nextInt();
        System.out.print("Max: ");
        int max = scanner.nextInt();
        displayVehicles(dealership.vehiclesByMileage(min, max));
    }

    private void processGetByVehicleTypeRequest(){
        System.out.println("--------Display vehicles by type--------");
        System.out.print("Type: ");
        String type = scanner.next();
        displayVehicles(dealership.vehiclesByType(type));
    }

    private void processGetAllVehiclesRequest(){
        System.out.println("---------All Vehicles---------");
        displayVehicles(dealership.getAllVehicles());
    }

    private void processAddVehicleRequest(){
        System.out.println("--------Add vehicle--------");
        System.out.print("VIN: "); int vin = scanner.nextInt();
        System.out.print("Year: "); int year = scanner.nextInt();
        System.out.print("Make: "); String make = scanner.next();
        System.out.print("Model: "); String model = scanner.next();
        System.out.print("Type: "); String type = scanner.next();
        System.out.print("Color: "); String color = scanner.next();
        System.out.print("Odometer: "); int odo = scanner.nextInt();
        System.out.print("Price: "); double price = scanner.nextDouble();

        dealership.addVehicle(new Vehicle(vin, year, make, model, type, color, odo, price));
        System.out.println("Vehicle added.");
    }

    private void processRemoveVehicleRequest(){
        System.out.println("--------Remove vehicle--------");
        System.out.print("Enter VIN: ");
        int vin = scanner.nextInt();
        dealership.removeVehicle(vin);
        System.out.println("Vehicle removed if VIN matched.");
    }

    public static void displayVehicles(ArrayList<Vehicle> vehicles){
        for(Vehicle vehicle: vehicles){
            System.out.print(vehicle);
        }
    }
}