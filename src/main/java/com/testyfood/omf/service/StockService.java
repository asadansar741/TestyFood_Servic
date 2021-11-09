package com.testyfood.omf.service;

import com.testyfood.omf.model.Item;
import com.testyfood.omf.model.Restaurant;

import java.util.List;
import java.util.UUID;

public interface StockService {
    Item addNewItem(Item item);
    List<Item> itemListByRestaurantId(UUID restaurantId);
}
