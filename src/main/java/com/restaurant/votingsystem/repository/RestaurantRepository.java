package com.restaurant.votingsystem.repository;

import com.restaurant.votingsystem.model.Dish;
import com.restaurant.votingsystem.model.Restaurant;

import java.util.List;

public interface RestaurantRepository {

    // null if not found, when updated
    Restaurant save(Restaurant restaurant);

    // false if not found
    boolean delete(int id);

    // null if not found
    Restaurant get(int id);

    List<Restaurant> getAll();

    Restaurant getWithMenu(int id);
}
