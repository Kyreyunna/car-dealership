package com.pluralsight;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private Dealership dealership;

    private void displayVehicles(List<Vehicle>vehicleList){
        //I think I will need to read all lines on file to display all vehicles to the console
        //or just print vehicle list
        //print vehicleList
        if(vehicleList.isEmpty()){
            System.out.println("List is empty");
            return;//return means stop sometimes
        }
        for (Vehicle vehicle : vehicleList) {
            System.out.printf(vehicle.toString());
        }

    }

    private void init() {
    // loads the dealership with the file manager

        DealershipFileManager dealershipFileManager= new DealershipFileManager();
//        dealershipFileManager.getDealership();
        this.dealership= dealershipFileManager.getDealership();
    }

    public UserInterface() {

    }

    public void display() {
        Scanner scanner = new Scanner(System.in);


        init();
        System.out.println("This is the " + dealership.getName() + " inventory management system");
        while (true) {
            System.out.println("Select a number from following options:");
            System.out.println("\t1 - Find vehicles by price");
            System.out.println("\t2 - Find vehicles by make/model");
            System.out.println("\t3 - Find vehicles by year");
            System.out.println("\t4 - Find vehicles by color");
            System.out.println("\t5 - Find vehicles by mileage range");
            System.out.println("\t6 - Find vehicles by type");
            System.out.println("\t7 - View all vehicles");
            System.out.println("\t8 - Add a vehicle");
            System.out.println("\t9 - Remove a vehicle");
            System.out.println("\t0 - Exit");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> processGetByPriceRequest();
                case 2 -> processGetByMakeModelRequest();
                case 3 -> processGetByYearRequest();
                case 4 -> processGetByColorRequest();
                case 5 -> processGetByMileageRequest();
                case 6 -> processGetByVehicleTypeRequest();
                case 7 -> processGetAllVehiclesRequest();
                case 8 -> processRemoveVehicleRequest();
                case 0 -> {
                    System.out.println("goodbye");
                    System.exit(0);
                }
            }
        }
    }

    public void processGetByPriceRequest() {

    }

    public void processGetByMakeModelRequest() {

    }

    public void processGetByYearRequest() {

    }

    public void processGetByColorRequest() {

    }

    public void processGetByMileageRequest() {

    }

    public void processGetByVehicleTypeRequest() {

    }

    public void processGetAllVehiclesRequest() {
        List<Vehicle>allVehicles = dealership.getAllVehicles();
        displayVehicles(allVehicles);
        //hand allVehicles to displayVehicles
    }

    public void processRemoveVehicleRequest() {

    }

    public void processAddVehicleRequest() {

    }
    public void appendtoCSV(String record){
        try {


            FileWriter fileWriter = new FileWriter("inventory.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(record);
            bufferedWriter.newLine();

            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
