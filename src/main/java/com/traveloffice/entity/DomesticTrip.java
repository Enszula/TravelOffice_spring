package com.traveloffice.entity;

import java.time.LocalDate;

public class DomesticTrip extends Trip {
    private Double ownArrivalDiscount;

    public DomesticTrip(LocalDate start, LocalDate end, String destination) {
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
