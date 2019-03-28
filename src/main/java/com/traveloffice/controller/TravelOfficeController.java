package com.traveloffice.controller;

import com.traveloffice.entity.AbroadTrip;
import com.traveloffice.entity.Customer;
import com.traveloffice.entity.DomesticTrip;
import com.traveloffice.entity.Trip;
import com.traveloffice.exceptions.NoSuchCustomerException;
import com.traveloffice.exceptions.NoSuchTripException;
import com.traveloffice.service.TravelOfficeService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
public class TravelOfficeController {

    TravelOfficeService travelOfficeService = new TravelOfficeService();

    public TravelOfficeController() {}

    @PostMapping(value = "/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer) {
        return travelOfficeService.addCustomer(customer);
    }

    @GetMapping(value = "/getCustomerCount")
    public int getCustomerCount() {
        return travelOfficeService.getCustomerCount();
    }

    @GetMapping(value = "/getCustomers")
    public Set<Customer> getCustomers () {
        return travelOfficeService.getCustomers();
    }

    @GetMapping(value = "/findCustomerByName")
    public Customer findCustomerByName (@RequestBody String customerName) throws NoSuchCustomerException {
        return travelOfficeService.findCustomerByName(customerName);
    }

    @DeleteMapping(value = "/removeCustomer")
    public boolean removeCustomer (@RequestParam String customerName) throws NoSuchCustomerException {
        Customer customerToDelete = travelOfficeService.findCustomerByName(customerName);
        return travelOfficeService.removeCustomer(customerToDelete);
    }

    @PostMapping(value = "/addDomesticTrip")
    public DomesticTrip addDomesticTrip(@RequestParam String tripName, @RequestBody DomesticTrip domesticTrip) {
        return (DomesticTrip)travelOfficeService.addTrip(tripName, domesticTrip);


    }

    @PostMapping(value = "/addAbroadTrip")
    public AbroadTrip addAbroadTrip(@RequestParam String tripName, @RequestBody AbroadTrip abroadTrip) {
        return (AbroadTrip)travelOfficeService.getTrips().put(tripName, abroadTrip);

    }

    @GetMapping(value = "/getTrips")
    public Map<String, Trip> getTrips () {
        return travelOfficeService.getTrips();
    }

    @DeleteMapping(value = "/removeTrip")
    public boolean removeTrip(@RequestParam String tripName) throws NoSuchTripException {
        return travelOfficeService.removeTrip(tripName);
    }
}
