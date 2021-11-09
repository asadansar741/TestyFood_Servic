package com.testyfood.omf.repository;

import com.testyfood.omf.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface OrderRepository extends JpaRepository<Order, UUID> {

    Order getOrderByOrderId(UUID orderId);
}
