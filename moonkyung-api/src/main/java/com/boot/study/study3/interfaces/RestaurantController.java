package com.boot.study.study3.interfaces;

import com.boot.study.study3.domain.Restaurant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class RestaurantController {

    @GetMapping("/restaurants")
    public List<Restaurant> list () {

        List<Restaurant> restaurants = new ArrayList<>();
        Restaurant restaurant = Restaurant.builder()
                .id(109L)
                .name("충내")
                .address("서초구")
                .information("커염둥이임")
                .build();
        restaurants.add(restaurant);
        return restaurants;

    }

    @GetMapping("/restaurants/{id}")
    public Restaurant detail(@PathVariable Long id) {
        List<Restaurant> restaurants = new ArrayList<>();

        restaurants.add(Restaurant.builder().id(109L).name("충내").build());
        restaurants.add(Restaurant.builder().id(101L).name("승균").build());

        Restaurant restaurant = restaurants.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElse(null);

        return restaurant;
    }

}
