package org.example;

public class SalesContract extends Contract {
    private boolean isFinanced;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
    }
    // if(isfinanced)return monthlypayment*numberofmonthforloan+( getSalesTaxAmount()
    // +getRecordingFee()+getProcessingFee()) Else return vehiclePrice +( getSalesTaxAmount()
    // +getRecordingFee()+getProcessingFee())


    public boolean isFinanced() {
        return isFinanced;
    }

    public double salesTax() {
        return getVehicleSold().getPrice() * 0.05;
    }

    public int recordingFee() {
        return 100;
    }

    public double processingFee() {
        double price = getVehicleSold().getPrice();
        double processingFee = 0;
        if (price < 10000) {
            processingFee = 295;
        } else {
            processingFee = 495;
        }
        return processingFee;
    }
    @Override
    public double getMonthlyPayment() {
        double P = getVehicleSold().getPrice();//principal loan amount
        double r = 0.0425/12;                  //monthly interest rate
        double R = 0.0525/12;                  //monthly interest rate
        if(isFinanced && P>=10000){
            return (P*r*Math.pow(1+r,48))/(Math.pow(1+r,48)-1);
        }
        else if(isFinanced && P<10000){
            return (P*R*Math.pow(1+R,24))/(Math.pow(1+R,24)-1);
        }
        else{
            return 0;
        }

    }
    public double getTotalPrice() {
        double basePrice = getVehicleSold().getPrice();
        double totalPrice;
        if (isFinanced) {
            if (basePrice >= 10000) { //4.25% at 48 months
                double r = 0.0425 / 12;
                totalPrice = (48 * (basePrice * r * Math.pow(1 + r, 48)) / (Math.pow(1 + r, 48) - 1))
                        + recordingFee() + processingFee() + salesTax();
            } else {                    //5.25% at 24 months
                double r = 0.0525 / 12;
                totalPrice = (24 * (basePrice * r * Math.pow(1 + r, 24)) / (Math.pow(1 + r, 24) - 1))
                        + recordingFee() + processingFee() + salesTax();
            }
        } else {

            totalPrice = basePrice + recordingFee() + processingFee() + salesTax();
        }
        return totalPrice;
    }
}