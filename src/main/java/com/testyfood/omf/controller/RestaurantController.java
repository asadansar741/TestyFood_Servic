package com.testyfood.omf.controller;


import com.testyfood.omf.model.Restaurant;
import com.testyfood.omf.service.RestaurantService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/restaurant/")
@RestController
public class RestaurantController {

    private final RestaurantService restaurantService;

    @PostMapping(path = "addrestaurant")
    public ResponseEntity addNewRestaurant(@RequestBody @Validated Restaurant Restaurant){
        return new ResponseEntity<>(restaurantService.saveNewRestaurant(Restaurant), HttpStatus.CREATED);
    }

    @GetMapping("/restaurantlist")
    List<Restaurant> getAllRestaurant() {
        return restaurantService.restaurantList();
    }

    @GetMapping("/restaurantbyname/{restaurantName}")
    List<Restaurant> getRestaurantByName(@PathVariable String restaurantName) {
        return restaurantService.getRestaurantByName(restaurantName);
    }

    @GetMapping("/restaurantbyfield/{field}")
    List<Restaurant> getRestaurantByField(@PathVariable String field) {
        return restaurantService.getRestaurantByField(field);
    }

}
