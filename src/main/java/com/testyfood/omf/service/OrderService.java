package com.testyfood.omf.service;

import com.testyfood.omf.model.Order;
import com.testyfood.omf.model.Restaurant;
import org.aspectj.weaver.ast.Or;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    Order saveNewOrder(Order order);

    Order getOrderByOrderId(UUID orderId);
    Order updateOrderStatus(UUID orderId, String status);
}
