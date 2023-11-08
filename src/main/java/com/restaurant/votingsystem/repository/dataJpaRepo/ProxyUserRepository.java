package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface ProxyUserRepository extends JpaRepository<User, Integer>
{

    @Query("SELECT u from User u LEFT JOIN FETCH u.roles WHERE u.email=:email")
	User getUserByEmail(@Param("email") String email);

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.id=:id")
	int delete(@Param("id") int id);

    @Query("SELECT u.restaurantVotedId from User u where u.id=:id")
	int getChosenRestaurantId(@Param("id") int id);
}
