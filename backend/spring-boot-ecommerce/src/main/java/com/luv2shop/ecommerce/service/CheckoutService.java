package com.luv2shop.ecommerce.service;

import com.luv2shop.ecommerce.dto.Purchase;
import com.luv2shop.ecommerce.dto.PurchaseResponse;

public interface CheckoutService {

    PurchaseResponse placeOrder(Purchase purchase);
}
