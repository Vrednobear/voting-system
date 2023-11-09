package com.restaurant.votingsystem.repository;

import com.restaurant.votingsystem.model.Dish;
import com.restaurant.votingsystem.model.Restaurant;

import java.util.List;

public interface DishRepository {

	Dish save(Dish dish);

	// false if not found
	boolean delete(int id);

	// null if not found
	Dish get(int id);

	List<Dish> getAllByRestId(int restaurantId);

	List<Dish> getAll();

	Dish getWithRestaurant(int id);
}
