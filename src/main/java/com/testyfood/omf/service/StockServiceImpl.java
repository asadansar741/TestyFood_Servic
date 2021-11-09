package com.testyfood.omf.service;

import com.testyfood.omf.model.Item;
import com.testyfood.omf.model.Restaurant;
import com.testyfood.omf.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class StockServiceImpl implements StockService {

    private final StockRepository repository;

    @Override
    public Item addNewItem( Item item) {
        return repository.save(item);
    }

    @Override
    public List<Item> itemListByRestaurantId(UUID restaurantId) {
        return repository.getItemByRestaurantId(restaurantId);
    }
}
