package com.luv2shop.ecommerce.dto;

import lombok.Data;

import java.util.Set;

import com.luv2shop.ecommerce.entity.Address;
import com.luv2shop.ecommerce.entity.Customer;
import com.luv2shop.ecommerce.entity.Order;
import com.luv2shop.ecommerce.entity.OrderItem;

@Data
public class Purchase {

    private Customer customer;
    private Address shippingAddress;
    private Address billingAddress;
    private Order order;
    private Set<OrderItem> orderItems;

}
