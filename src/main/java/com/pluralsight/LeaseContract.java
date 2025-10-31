package com.pluralsight;

public class LeaseContract extends Contract{
    private double expectedEndingValue;
    private double leaseFee;

    public LeaseContract(String date, String customerName, String customerDate, Vehicle vehicleSold, double expectedEndingValue, double leaseFee) {
        super(date, customerName, customerDate, vehicleSold);
        this.expectedEndingValue = getVehicleSold().getPrice() * 0.5;
        this.leaseFee = getVehicleSold().getPrice() * 0.07;
    }


    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }

    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }

    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }

}
