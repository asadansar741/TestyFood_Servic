package com.testyfood.omf.controller;


import com.testyfood.omf.model.Item;
import com.testyfood.omf.model.Restaurant;
import com.testyfood.omf.service.RestaurantService;
import com.testyfood.omf.service.StockService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RequestMapping("/stock/")
@RestController
public class StockController {

    private final StockService stockService;

    @PostMapping(path = "additem")
    public ResponseEntity addNewItem(@RequestBody @Validated Item item){
        return new ResponseEntity<>(stockService.addNewItem(item), HttpStatus.CREATED);
    }

    @GetMapping("itemlist/{restaurantId}")
    List<Item> getItemListByRestaurantId(@PathVariable String restaurantId) {
        return stockService.itemListByRestaurantId(UUID.fromString(restaurantId));
    }

}
