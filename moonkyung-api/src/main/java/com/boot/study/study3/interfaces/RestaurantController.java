package com.boot.study.study3.interfaces;

import com.boot.study.study3.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list () {

        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = Restaurant.builder()
                .name("충내")
                .address("서초구")
                .build();
        restaurants.add(restaurant);
        return restaurants;

    }

}
