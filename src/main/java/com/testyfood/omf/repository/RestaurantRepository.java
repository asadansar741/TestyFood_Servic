package com.testyfood.omf.repository;

import com.testyfood.omf.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, UUID> {

    List<Restaurant> findAll();

    List<Restaurant> getRestaurantByRestaurantName(String restaurantName);

//    List<Restaurant> getRestaurantByLatitudeAndLongitude();
}
