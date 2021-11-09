package com.testyfood.omf.service;

import com.testyfood.omf.model.Restaurant;
import java.util.List;

public interface RestaurantService {
    Restaurant saveNewRestaurant(Restaurant restaurant);

    List<Restaurant> restaurantList();

    List<Restaurant> getRestaurantByName(String restaurantName);

    List<Restaurant> getRestaurantByField(String field);

//    List<Restaurant> restaurantListByLatitudeAndLongitude();
}
