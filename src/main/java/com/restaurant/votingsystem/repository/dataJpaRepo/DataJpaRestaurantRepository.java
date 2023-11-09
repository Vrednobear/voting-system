package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.model.Dish;
import com.restaurant.votingsystem.model.Restaurant;
import com.restaurant.votingsystem.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaRestaurantRepository implements RestaurantRepository {

    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    @Autowired
    ProxyRestaurantRepository proxy;
    
    @Override
    public Restaurant save(Restaurant restaurant) {
        return proxy.save(restaurant);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public Restaurant get(int id) {
        return proxy.findById(id).orElse(null);
    }

    @Override
    public List<Restaurant> getAll() {
        return proxy.findAll(SORT_NAME);
    }

    @Override
    public Restaurant getWithMenu(int id) {
        return proxy.getWithMenu(id);
    }
}
