package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.model.Dish;
import com.restaurant.votingsystem.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaDishRepository implements DishRepository {

	private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

	@Autowired
	ProxyDishRepository proxy;

	@Override
	public Dish save(Dish dish) {
		return proxy.save(dish);
	}

	@Override
	public boolean delete(int id) {
		return proxy.delete(id) != 0;
	}

	@Override
	public Dish get(int id) {
		return proxy.findById(id).orElse(null);
	}

	@Override
	public List<Dish> getAllByRestId(int restaurantId) {
		return proxy.findAllByRestId(restaurantId);
	}

	@Override
	public List<Dish> getAll() {
		return proxy.findAll();
	}

	@Override
	public Dish getWithRestaurant(int id) {
		return proxy.getWithRestaurant(id);
	}
}
