package com.online_booking_ticket.movie_online_booking_ticket.controllers;

import com.online_booking_ticket.movie_online_booking_ticket.dto.CustomerDTO;
import com.online_booking_ticket.movie_online_booking_ticket.entities.Customer;
import com.online_booking_ticket.movie_online_booking_ticket.repositories.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerRepo customerRepo;

    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getCustomers() {
        return customerRepo.findAll().isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(customerRepo.findAll());
    }

    @PostMapping("/customers")
    public ResponseEntity<String> insertCustomer(@RequestBody CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setName(customerDTO.getName());
        customer.setAddress(customerDTO.getAddress());
        customerRepo.save(customer);
        return ResponseEntity.ok("Customer inserted successfully");
    }
}
