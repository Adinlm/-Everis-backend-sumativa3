package com.luv2shop.ecommerce.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luv2shop.ecommerce.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByEmail(String theEmail);

}
