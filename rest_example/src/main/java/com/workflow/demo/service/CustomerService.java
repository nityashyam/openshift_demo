package com.workflow.demo.service;

import com.workflow.demo.entity.Customer;
import com.workflow.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerRepository custRepo;


    public List<Customer> listAll() {
        return custRepo.findAll();
    }

    public Customer save(Customer customer) {
        return custRepo.save(customer);
    }

    public Customer get(Long id) {
        return custRepo.findById(id).orElse(null);
    }

    public void delete(Long id) {
        custRepo.deleteById(id);
    }



}