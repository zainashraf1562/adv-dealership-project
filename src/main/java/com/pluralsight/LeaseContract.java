package com.pluralsight;

public class LeaseContract extends Contract{


//    @Override
//    public double getTotalPrice() {
//        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
//    }
//
//    @Override
//    public double getMonthlyPayment() {
//        int numberOfPayments = 36;
//        double interestRate = 4.0 / 1200;
//        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
//        monthlyPayment = Math.round(monthlyPayment * 100);
//        monthlyPayment /= 100;
//        return monthlyPayment;
//    }
}
