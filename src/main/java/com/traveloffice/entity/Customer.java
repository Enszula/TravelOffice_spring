package com.traveloffice.entity;

public class Customer {
    String name;
    private Address address;
    private Trip trip;

    public Customer(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public Customer(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void assignTrip(Trip trip) {
        this.trip = trip;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address=" + address +
                ", trip=" + trip +
                '}';
    }
}
