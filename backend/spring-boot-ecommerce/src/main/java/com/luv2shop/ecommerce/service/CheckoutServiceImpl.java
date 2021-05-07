package com.luv2shop.ecommerce.service;

import com.luv2shop.ecommerce.dao.CustomerRepository;
import com.luv2shop.ecommerce.dto.Purchase;
import com.luv2shop.ecommerce.dto.PurchaseResponse;
import com.luv2shop.ecommerce.entity.Customer;
import com.luv2shop.ecommerce.entity.Order;
import com.luv2shop.ecommerce.entity.OrderItem;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Set;
import java.util.UUID;

@Service
public class CheckoutServiceImpl implements CheckoutService {

    private CustomerRepository customerRepository;

    public CheckoutServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {

        // recuperar la información del pedido de dto
        Order order = purchase.getOrder();

        // generar número de seguimiento
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);

        // completar orden con orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));

        // completar orden conh billingAddress y shippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());

        // rellenar al cliente con el pedido
        Customer customer = purchase.getCustomer();

        // comprobar si se trata de un cliente existente
        String theEmail = customer.getEmail();

        Customer customerFromDB = customerRepository.findByEmail(theEmail);

        if (customerFromDB != null) {
            // encontro cliente entonces se asigna como corresponde
            customer = customerFromDB;
        }

        customer.add(order);

        // guardar en la base de datos
        customerRepository.save(customer);

        // retorna una respuesta
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {

        // generar un número UUID aleatorio (UUID versión-4)
        // He aqui los detalles :) ---> https://en.wikipedia.org/wiki/Universally_unique_identifier
        //
        return UUID.randomUUID().toString();
    }
}









