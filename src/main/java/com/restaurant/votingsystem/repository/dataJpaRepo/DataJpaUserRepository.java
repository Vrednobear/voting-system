package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.model.User;
import com.restaurant.votingsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DataJpaUserRepository implements UserRepository {

    @Autowired
    ProxyUserRepository proxy;

    @Override
    public User save(User user) {
        return proxy.save(user);
    }

    @Override
    public boolean delete(int id) {
        return proxy.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return proxy.findById(id).orElse(null);
    }

    @Override
    public User getByEmail(String email) {
        return proxy.getUserByEmail(email);
    }

    @Override
    public List<User> getAll() {
        return proxy.findAll(Sort.by(Sort.Direction.ASC, "name", "email"));
    }

    @Override
    public Integer getChosenRestaurantId(int id) {
        return proxy.getChosenRestaurantId(id);
    }
}
