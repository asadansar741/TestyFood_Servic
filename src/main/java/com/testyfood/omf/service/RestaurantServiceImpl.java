package com.testyfood.omf.service;

import com.testyfood.omf.model.Restaurant;
import com.testyfood.omf.repository.RestaurantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;

    @Override
    public Restaurant saveNewRestaurant(Restaurant restaurant) {
        return restaurantRepository.save(restaurant);
    }

    @Override
    public List<Restaurant> restaurantList() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> getRestaurantByName(String restaurantName) {
        return restaurantRepository.getRestaurantByRestaurantName(restaurantName);
    }

    @Override
    public List<Restaurant> getRestaurantByField(String field) {
        List<Restaurant> restaurantList = restaurantRepository.findAll();
        return restaurantList.stream().filter(restaurant ->
                restaurant.getRestaurantName().toLowerCase().contains(field.toLowerCase())
                        || restaurant.getCity().toLowerCase().contains(field.toLowerCase())
                        || restaurant.getAddress().toLowerCase().contains(field.toLowerCase())).collect(Collectors.toList());
    }

}
