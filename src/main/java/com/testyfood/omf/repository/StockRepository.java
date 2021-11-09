package com.testyfood.omf.repository;

import com.testyfood.omf.model.Item;
import com.testyfood.omf.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface StockRepository extends JpaRepository<Item, UUID> {

//    List<Item> findAll();

    List<Item> getItemByRestaurantId(UUID restaurantId);

    Item getItemByItemId(UUID itemId);
}
