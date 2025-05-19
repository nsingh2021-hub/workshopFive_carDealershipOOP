package com.ps;

import java.io.*;
import java.util.ArrayList;

public class ContractFileManager {

    private static final String CONTRACT_FILE = "contracts.csv";

    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(CONTRACT_FILE, true))) {
            writer.write(contract.getContractDetails());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Contract> loadContracts() {
        ArrayList<Contract> contracts = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(CONTRACT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
// You can add logic to parse the line and create contract objects
// This is a simplified version
                String[] parts = line.split(",");
                String name = parts[0];
                String email = parts[1];
// Create the contract based on the data (you would need to improve this logic)
                contracts.add(new SalesContract(name, email, new Vehicle(0, 0, "", "", "", "", 0, 0), true));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contracts;
    }
}
