package org.example;

public class Vehicle extends Asset {

    public String makeModel;
    public int year;
    public int odometer;

    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {
        super(description, dateAcquired, originalCost);
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getOdometer() {
        return odometer;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    int carAge = 2023 - year;
    @Override
    public double getValue(){
        var finalValue = this.getOriginalCost();

        //someone screwed up
        if(this.year < 0){
            throw new IllegalArgumentException("Car can't be less than 0 years old");
        }
        else if(this.year >= 0 && this.year <= 3){
            finalValue *= 1 - (this.year * .03);
        }
        else if(this.year >= 4 && this.year <= 6){
            finalValue *= 1 - (this.year * .06);
        }
        else if(this.year >= 7 && this.year <= 10 ){
            finalValue *= 1 - (this.year * .08);
        }
        else{
            finalValue = 1000;
        }

        //possible makeModel could be Honda Civic
        if(this.odometer > 100000 &&
                (!this.makeModel.toLowerCase().contains("honda") ||
                        !this.makeModel.toLowerCase().contains("toyota"))){
            finalValue *= .75;
        }

        return finalValue;
    }

    @Override
    public double getTaxableValue() {
        return 0;
    }
}
