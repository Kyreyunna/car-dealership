package com.pluralsight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.regex.Pattern;

public class DealershipFileManager {
    public Dealership getDealership() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("inventory.csv"));

            boolean isHeader = true;
            String line;
            Dealership dealership = new Dealership();
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitValues = line.split(Pattern.quote("|"));

                if (isHeader) {
//                   Does this go here? dealership = new Dealership(splitValues[0], splitValues[1], splitValues[2]);
                    dealership.setName(splitValues[0]);
                    dealership.setAddress(splitValues[1]);
                    dealership.setPhone(splitValues[2]);
                    isHeader = false;
                } else {
                    //deal with each property of vehicle
                    int vin = Integer.parseInt (splitValues[0]);
                    int year = Integer.parseInt (splitValues[1]);
                    String make = splitValues[2];
                    String model = splitValues[3];
                    String type = splitValues[4];
                    String color= splitValues[5];
                    int odometer = Integer.parseInt (splitValues[6]);
                    BigDecimal price = BigDecimal.valueOf(Double.parseDouble(splitValues[7]));

                    dealership.addVehicle(new Vehicle(vin,year,odometer,make,model,color,type,price));
                }

            }
            return dealership;

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveDealership(Dealership dealership) {
    //overwrite update file later
    }
}
