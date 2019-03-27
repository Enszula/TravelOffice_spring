package com.traveloffice.to;

import com.traveloffice.entity.Customer;
import com.traveloffice.entity.Trip;
import com.traveloffice.exceptions.NoSuchCustomerException;
import com.traveloffice.exceptions.NoSuchTripException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class TravelOffice {
    private Set<Customer> customers = new HashSet<>();
    private Map<String, Trip> trips = new HashMap<>();

    public Customer addCustomer(Customer customer) {
        customers.add(customer);
        return customer;
    }

    public int getCustomerCount() {
        int customerCount = 0;
        for (Customer c : customers)
            if (c instanceof Customer)
                customerCount++;

        return customerCount;
    }

    public void addTrip(String tripName, Trip trip) {
        trips.put(tripName, trip);
    }

    public boolean removeTrip(String tripName) throws NoSuchTripException {
        if (trips.containsKey(tripName)) {
            trips.remove(tripName);
            return true;
        } else
            throw new NoSuchTripException("Nie ma takiej wycieczki!");

    }

        public Customer findCustomerByName (String customerName) throws NoSuchCustomerException {
            for (Customer c : customers) {
                if (c.getName().startsWith(customerName))
                    return c;
                else
                    throw new NoSuchCustomerException("Nie ma takiego klienta!");
            }

            return null;
        }

        public boolean removeCustomer (Customer customer) throws NoSuchCustomerException {
            if (customer == null)
                throw new NoSuchCustomerException("Nie ma takiego klienta do usuniecia!");

            return customers.remove(customer);
        }

        public Set<Customer> getCustomers () {
            return customers;
        }

        public Map<String, Trip> getTrips () {
            return trips;
        }

        @Override
        public String toString () {
            String s = "";
            for (Customer c : customers)
                if (c instanceof Customer)
                    s += c + "\n";

            return "TravelOffice{" +
                    "customers=\n" + s +
                    '}';
        }
}
