package com.traveloffice.controller;

import com.traveloffice.entity.AbroadTrip;
import com.traveloffice.entity.Customer;
import com.traveloffice.entity.DomesticTrip;
import com.traveloffice.entity.Trip;
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

    @GetMapping(value = "/getCustomers")
    public Set<Customer> getCustomers () {
        return travelOfficeService.getCustomers();
    }

    @PostMapping(value = "/addTrip")
    public int addDomesticTrip(@RequestParam String tripName, @RequestBody Trip tirp) {
        travelOfficeService.addTrip(tripName, tirp);
        return 99;

    }

    @PostMapping(value = "/addDomesticTrip")
    public Trip addDomesticTrip(@RequestBody String tripName, @RequestBody DomesticTrip domesticTrip) {
        return travelOfficeService.getTrips().put(tripName, domesticTrip);

    }

    /*    @PostMapping(value = "/addAbroadTrip")
    public Trip addAbroadTrip(@RequestBody String tripName, @RequestBody AbroadTrip abroadTrip) {
        return travelOfficeService.getTrips().put(tripName, abroadTrip);
    }
*/

    @GetMapping(value = "/getTrips")
    public Map<String, Trip> getTrips () {
        return travelOfficeService.getTrips();
    }



}
