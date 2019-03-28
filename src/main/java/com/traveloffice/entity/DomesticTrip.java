package com.traveloffice.entity;

public class DomesticTrip extends Trip {
    private Double ownArrivalDiscount;

    public DomesticTrip(MyDate start, MyDate end, String destination) {
        super(start, end, destination);
    }


    public void setOwnArrivalDiscount(Double ownArrivalDiscount) {
        this.ownArrivalDiscount = ownArrivalDiscount;
    }

    public Double getOwnArrivalDiscount() {
        return ownArrivalDiscount;
    }

    @Override
    public Double getPrice() {
        return super.getPrice() - this.getOwnArrivalDiscount();
    }
}
