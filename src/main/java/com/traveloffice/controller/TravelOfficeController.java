package com.traveloffice.controller;

import com.traveloffice.entity.AbroadTrip;
import com.traveloffice.entity.Customer;
import com.traveloffice.entity.DomesticTrip;
import com.traveloffice.entity.Trip;
import com.traveloffice.service.TravelOfficeService;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class TravelOfficeController {

    TravelOfficeService travelOfficeService = new TravelOfficeService();

    public TravelOfficeController() {}

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return travelOfficeService.addCustomer(customer);
    }

    @GetMapping(value = "/getCustomers")
    public Set<Customer> getCustomers () {
        return travelOfficeService.getCustomers();
    }

    @PostMapping(value = "/addDomesticTrip")
    public DomesticTrip addDomesticTrip(String tripName, DomesticTrip domesticTrip) {
        return (DomesticTrip)travelOfficeService.getTrips().put(tripName, domesticTrip);

    }

    @PostMapping(value = "/addAbroadTrip")
    public AbroadTrip addAbroadTrip(String tripName, AbroadTrip abroadTrip) {
        return (AbroadTrip)travelOfficeService.getTrips().put(tripName, abroadTrip);

    }



}
