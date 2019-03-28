package com.traveloffice.controller;

import com.traveloffice.entity.*;
import com.traveloffice.exceptions.NoSuchCustomerException;
import com.traveloffice.service.TravelOfficeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


@RunWith(JUnit4.class)
@WebMvcTest(TravelOfficeController.class)
public class TravelOfficeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TravelOfficeService travelOfficeService;

    private Customer customer;
    private DomesticTrip domesticTrip;
    private AbroadTrip abroadTrip;

    private TravelOfficeController travelOfficeController;

    @Before
    public void setUp() throws NoSuchCustomerException {
        travelOfficeController = new TravelOfficeController();
        travelOfficeService = mock(TravelOfficeService.class);

        Address address = new Address("Opolska 22", "40-091", "Katowice");
        customer = new Customer("Jan Kowalski", address);

        MyDate startDate = new MyDate(2019,03,19);
        MyDate endDate = new MyDate(2019,03,29);
        domesticTrip = new DomesticTrip(startDate, endDate, "Katowice");
        domesticTrip.setPrice(8000.0);
        abroadTrip = new AbroadTrip(startDate, endDate, "London");
    }

    @Test
    public void AddCustomer() throws NoSuchCustomerException {
        assertEquals(customer, travelOfficeController.addCustomer(customer));
        /*when(travelOfficeService.addCustomer(customer)).thenReturn(customer);
        assertEquals(customer, );*/
    }

    @Test
    public void getCustomerCount() {
        travelOfficeController.addCustomer(customer);
        assertEquals(1, travelOfficeController.getCustomerCount());
    }

    @Test
    public void getCustomers() {
        Set<Customer> customerSet = new HashSet<>();
        customerSet.add(customer);

        travelOfficeController.addCustomer(customer);

        assertEquals(customerSet , travelOfficeController.getCustomers());
    }

    @Test
    public void findCustomerByName() throws NoSuchCustomerException {
        travelOfficeController.addCustomer(customer);
        assertEquals(customer, travelOfficeController.findCustomerByName("Jan Kowalski"));

    }

    @Test
    public void removeCustomer() throws NoSuchCustomerException {
        travelOfficeController.addCustomer(customer);
        assertEquals(true, travelOfficeController.removeCustomer("Jan Kowalski"));
    }

//    @Test
//    public void addDomesticTrip() {
//
//        System.out.println("domesticTrip price: " + domesticTrip.getPrice());
//
//        DomesticTrip trip = travelOfficeController.addDomesticTrip("Katowice", domesticTrip);
//        System.out.println(trip.getPrice());
//        assertEquals(domesticTrip, trip);
//    }

//    @Test
//    public void addAbroadTrip() {
//        System.out.println("abroadTrip price: " + domesticTrip.getPrice());
//        abroadTrip.setPrice(3000.0);
//
//        Trip trip = travelOfficeController.addAbroadTrip("London", abroadTrip);
//        assertEquals(abroadTrip, trip);
//    }

    @Test
    public void getTrips() {
        domesticTrip.setPrice(8000.0);
        abroadTrip.setPrice(3000.0);
        Map<String, Trip> trips = new HashMap<>();

        trips.put("London" , abroadTrip);
        trips.put("Katowice" , domesticTrip);

        travelOfficeController.addDomesticTrip("Katowice" , domesticTrip);

        travelOfficeController.addAbroadTrip("London" , abroadTrip);

        assertEquals(trips, travelOfficeController.getTrips());
    }

    @Test
    public void removeTrip() {
        fail("Nah tested");
    }
}