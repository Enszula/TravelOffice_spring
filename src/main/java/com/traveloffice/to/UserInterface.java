package com.traveloffice.to;

import com.traveloffice.entity.Customer;
import com.traveloffice.entity.Trip;

public interface UserInterface {
        Customer addCustomer();

        Trip addTrip();

        void assign();

        boolean removeCustomer();

        boolean removeTrip();

        void showTrips();

        void showCustomers();
}
