package com.traveloffice.repository;

import com.traveloffice.entity.Customer;
import com.traveloffice.entity.Trip;
import com.traveloffice.exceptions.NoSuchCustomerException;
import com.traveloffice.exceptions.NoSuchTripException;

import java.util.Map;
import java.util.Set;

public interface TravelOfficeRepository {
    int getCustomerCount();

    boolean removeTrip(String tripName);

    Customer findCustomerByName (String customerName);

    Set<Customer> getCustomers ();

    Map<String, Trip> getTrips ();
}
