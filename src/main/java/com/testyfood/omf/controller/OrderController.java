package com.testyfood.omf.controller;


import com.testyfood.omf.model.Order;
import com.testyfood.omf.model.Status;
import com.testyfood.omf.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/order/")
@RestController
public class OrderController {

    private final OrderService orderService;

    @PostMapping(path = "neworder")
    public ResponseEntity newOrder(@RequestBody @Validated Order order){
        Order order1=orderService.saveNewOrder(order);
//        return new ResponseEntity<>(orderService.saveNewOrder(order), HttpStatus.CREATED);
        return new ResponseEntity<>("Order Success with OrderId: "+order1.getOrderId(), HttpStatus.CREATED);
    }

    @GetMapping("orderlist/{orderId}")
    public ResponseEntity<Order> getOrderByOrderId(@PathVariable String orderId) {
        return new ResponseEntity(Optional.of(orderService.getOrderByOrderId(UUID.fromString(orderId))),HttpStatus.FOUND);
//        return orderService.getOrderByOrderId(UUID.fromString(orderId));
    }

    @PutMapping("updateorderstatus/{orderId}")
    public Order updateOrderstatus(@PathVariable String orderId, @RequestBody Status status) {
        return orderService.updateOrderStatus(UUID.fromString(orderId),status.getStatus());
    }

}
