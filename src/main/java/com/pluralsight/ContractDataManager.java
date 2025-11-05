package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class ContractDataManager {

    public void saveContract(Contract contract) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("contracts.csv",true))) {

            String finOpt = "";
            if (contract instanceof SalesContract){
                if (((SalesContract) contract).isFinanceOption()){
                    finOpt = "YES";
                } else if (!(((SalesContract) contract).isFinanceOption())) {
                    finOpt = "NO";
                }
                bw.write("SALE|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|"
                        + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake()
                        + "|" + contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor()
                        + "|" + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice() + "|"
                        + ((SalesContract) contract).getSalesTaxAmount() + "|" + ((SalesContract) contract).getRecordingFee() + "|"
                        + ((SalesContract) contract).getProcessingFee() + "|" + contract.getTotalPrice() + "|" + finOpt + "|" + contract.getMonthlyPayment()
                );
                bw.newLine();

            } else if (contract instanceof LeaseContract) {
                bw.write("LEASE|" + contract.getDate() + "|" + contract.getCustomerName() + "|" + contract.getCustomerEmail() + "|"
                        + contract.getVehicleSold().getVin() + "|" + contract.getVehicleSold().getYear() + "|" + contract.getVehicleSold().getMake()
                        + "|" + contract.getVehicleSold().getModel() + "|" + contract.getVehicleSold().getVehicleType() + "|" + contract.getVehicleSold().getColor()
                        + "|" + contract.getVehicleSold().getOdometer() + "|" + contract.getVehicleSold().getPrice() + "|"
                        + ((LeaseContract) contract).getExpectedEndingValue() + "|" + ((LeaseContract) contract).getLeaseFee() + "|"
                        + contract.getTotalPrice() + "|" + contract.getTotalPrice() + "|" + contract.getMonthlyPayment()
                );
                bw.newLine();
            }
            System.out.println("saved successfully ");

        } catch (IOException e) {
            System.out.println("Error!");
        }
    }
}
