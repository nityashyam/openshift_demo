package com.workflow.demo.repository;

import com.workflow.demo.entity.CustOrderInfo;
import com.workflow.demo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.workflow.demo.entity.CustOrderDTO;


import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    @Query("SELECT c FROM Customer c WHERE upper(c.firstName) = upper(:firstName)")
    public List<Customer> find(@Param("firstName") String firstName);



}