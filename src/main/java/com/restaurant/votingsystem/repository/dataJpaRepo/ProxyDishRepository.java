package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.model.Dish;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface ProxyDishRepository extends JpaRepository<Dish, Integer> {

	@Transactional
	@Modifying
	@Query("DELETE FROM Dish d WHERE d.id=:id")
	int delete(@Param("id") int id);

	@Query("SELECT d FROM Dish d LEFT JOIN FETCH d.restaurant WHERE d.id=:id")
	Dish getWithRestaurant(@Param("id") int id);

	@Query("SELECT d from Dish d WHERE d.restaurant.id=:id ORDER BY d.price")
	List<Dish> findAllByRestId(@Param("id") int id);
}
