package com.testyfood.omf.service;

import com.testyfood.omf.model.Item;
import com.testyfood.omf.model.Order;
import com.testyfood.omf.model.OrderedItem;
import com.testyfood.omf.repository.OrderRepository;
import com.testyfood.omf.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;
    private final StockRepository stockRepository;

    @Override
    public Order saveNewOrder(Order order) {
        for (OrderedItem item: order.getItems()){
            Item byId = stockRepository.getItemByItemId(item.getItemId());
            byId.setStockQty(byId.getStockQty()-item.getQuantity());
            if(byId!=null && byId.getStockQty()>0)
                stockRepository.save(byId);
        }
        return repository.save(order);
    }

    @Override
    public Order getOrderByOrderId(UUID orderId) {
        return repository.getOrderByOrderId(orderId);
    }

    @Override
    public Order updateOrderStatus(UUID orderId, String status) {
        Order order=repository.getOrderByOrderId(orderId);
        if (order!=null){
            order.setStatus(status);
            return repository.save(order);
        }
        return null;
    }
}
