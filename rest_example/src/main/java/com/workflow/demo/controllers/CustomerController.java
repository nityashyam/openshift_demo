package com.workflow.demo.controllers;

import com.workflow.demo.entity.Customer;
import com.workflow.demo.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
@Api(value="Customer Management System", description="Crud Operations pertaining to customer")
public class CustomerController {

      @Autowired
    private CustomerService service;

    @GetMapping("/customer")
    //@PreAuthorize("hasRole('USER')")
    @ApiOperation(value = "View a list of available customers", response = List.class)

    public List<Customer> getAllCustomers() {
        return service.listAll();
    }

    @PostMapping("/customer")
    @ApiOperation(value = "Add a customer")
    public Customer createCustomer(@Valid @RequestBody Customer cust) {
        return service.save(cust);
    }


    @GetMapping("/customers/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long custId) {
        Customer customer = service.get(custId);

        if (customer!=null) {
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/customers/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable("id") long custId,@RequestBody Customer updatedCustomer) {
        Customer customer = service.get(custId);

        if (customer!=null) {
            updateExistingCustomer(customer,updatedCustomer);
            service.save(customer);
            return new ResponseEntity<>(customer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private void updateExistingCustomer(Customer customer, Customer updatedCustomer) {
        customer.setEmailId(updatedCustomer.getEmailId());
        customer.setFirstName(updatedCustomer.getFirstName());
        customer.setSecondName(updatedCustomer.getSecondName());
        customer.setMobileNumber(updatedCustomer.getMobileNumber());
    }


    @DeleteMapping("/customers/{id}")
    public Map<String, Boolean> deleteCustomer(@PathVariable(value = "id") Long customerId)
           {
       //Employee customer = service.get(customerId);
              // orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));

        service.delete(customerId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

   
}
