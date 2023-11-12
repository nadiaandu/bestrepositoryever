package org.example;

public class LeaseContract extends Contract {


    public LeaseContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }

    public double expectedPrice(){
        return getVehicleSold().getPrice() * 0.50;

    }
    @Override
    public double getTotalPrice(){
        return getMonthlyPayment() * 36;

    }
    public double leasingFee(){
        return getVehicleSold().getPrice() * 0.07;
    }

    @Override
    public double getMonthlyPayment(){
        return (getVehicleSold().getPrice() - expectedPrice() + leasingFee())
                /36+((getVehicleSold().getPrice() + expectedPrice() + leasingFee())* (4/2400));
    }
}
