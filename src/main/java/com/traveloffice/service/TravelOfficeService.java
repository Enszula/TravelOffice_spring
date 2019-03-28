package com.traveloffice.service;

import com.traveloffice.entity.Customer;
import com.traveloffice.entity.Trip;
import com.traveloffice.exceptions.NoSuchCustomerException;
import com.traveloffice.exceptions.NoSuchTripException;
import com.traveloffice.to.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class TravelOfficeService {

    private TravelOffice travelOffice = new TravelOffice();

    public Customer addCustomer(Customer customer) {
        return travelOffice.addCustomer(customer);
    }

    public int getCustomerCount() {
        return travelOffice.getCustomerCount();
    }

    public Trip addTrip(String tripName, Trip trip) {
        return travelOffice.getTrips().put(tripName, trip);
    }

    public boolean removeTrip(String tripName) throws NoSuchTripException {
        return travelOffice.removeTrip(tripName);
    }

    public Customer findCustomerByName (String customerName) throws NoSuchCustomerException {
        return travelOffice.findCustomerByName(customerName);
    }

    public boolean removeCustomer (Customer customer) throws NoSuchCustomerException {
        return travelOffice.removeCustomer(customer);
    }

    public Set<Customer> getCustomers () {
        return travelOffice.getCustomers();
    }

    public Map<String, Trip> getTrips () {
        return travelOffice.getTrips();
    }

    @Override
    public String toString () {
        return travelOffice.toString();
    }
}
