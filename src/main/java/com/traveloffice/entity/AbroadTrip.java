package com.traveloffice.entity;

public class AbroadTrip extends Trip {
    private Double insurance;

    public AbroadTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
    }

    public void setInsurance(Double insurance) {
        this.insurance = insurance;
    }

    public Double getInsurance() {
        return insurance;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() + this.getInsurance();
    }
}
