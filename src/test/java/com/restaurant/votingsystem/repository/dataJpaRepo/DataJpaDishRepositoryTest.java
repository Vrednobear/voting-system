package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.TestUtils;
import com.restaurant.votingsystem.model.Dish;
import com.restaurant.votingsystem.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.restaurant.votingsystem.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:/db/data.sql")
class DataJpaDishRepositoryTest {

	@Autowired
	DataJpaDishRepository repository;

	@Test
	void save() {
		Dish expected = getNewDish();
		Dish actual = repository.save(expected);
		expected.setId(actual.getId());
		assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
	}

	@Test
	void update() {
		Dish updDish = getNewDish();
		updDish.setId(DISH_ID);
		Dish actual = repository.save(updDish);
		Dish expected = getNewDish();
		expected.setId(actual.getId());

		assertThat(actual).isEqualToIgnoringGivenFields(expected, "restaurant");
	}

	@Test
	void delete() {
		repository.delete(DISH_ID);
		assertThat(repository.getAll().size()==7).isTrue();
		//assertThrows(NotFoundException.class, () -> service.get(USER_ID));
	}

	@Test
	void get() {
		Dish actual = repository.get(DISH_ID);
		assertThat(actual).isEqualToIgnoringGivenFields(DISH_1, "restaurant");
	}

	@Test
	void getAll() {
		List<Dish> actual = repository.getAll();
		assertThat(actual)
				.usingRecursiveFieldByFieldElementComparatorIgnoringFields("restaurant")
				.isEqualTo(ALL_DISHES);
	}

	@Test
	void getAllByRestId(){
		List<Dish> actual = repository.getAllByRestId(REST_ID);
		assertThat(actual)
				.usingRecursiveFieldByFieldElementComparatorIgnoringFields("restaurant")
				.isEqualTo(VESUVIO_MENU_BY_PRICE);
	}

	@Test
	void getWithRestaurant() {
		Dish actual = repository.getWithRestaurant(DISH_ID);
		Dish expected = getDishWithRest();
		assertThat(actual).isEqualToIgnoringGivenFields(expected,"restaurant");
		assertThat(actual.getRestaurant()).usingRecursiveComparison()
				.ignoringFields("menu")
				.isEqualTo(expected.getRestaurant());
	}
}