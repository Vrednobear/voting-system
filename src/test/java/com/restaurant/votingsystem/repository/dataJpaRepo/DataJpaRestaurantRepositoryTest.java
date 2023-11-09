package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.TestUtils;
import com.restaurant.votingsystem.model.Restaurant;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.restaurant.votingsystem.TestUtils.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.assertThrows;

@SpringBootTest
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:/db/data.sql")
class DataJpaRestaurantRepositoryTest {

    @Autowired
    DataJpaRestaurantRepository repository;

    @Test
    void save() {
        Restaurant newRestaurant = TestUtils.getNewRestaurant();
        Restaurant actual = repository.save(newRestaurant);
        newRestaurant.setId(actual.getId());
        assertThat(actual).isEqualToIgnoringGivenFields(newRestaurant, "menu");
    }

    @Test
    void update() {
        Restaurant updRestaurant = getNewRestaurant();
        updRestaurant.setId(REST_ID);
        updRestaurant.setName("NEW_VESUVIO");
        Restaurant actual = repository.save(updRestaurant);
        assertThat(actual).isEqualToIgnoringGivenFields(updRestaurant, "menu");
    }

    @Test
    void delete() {
        repository.delete(REST_ID);
        assertThat(repository.getAll().size() == 1).isTrue();
        //assertThrows(NotFoundException.class, () -> service.get(USER_ID));
    }

    @Test
    void get() {
        Restaurant actualRest = repository.get(REST_ID);
        assertThat(actualRest).isEqualToIgnoringGivenFields(VESUVIO, "menu");

    }

    @Test
    void getAll() {
        List<Restaurant> allActual = repository.getAll();
        List<Restaurant> allExpected = RESTAURANTS;
        assertThat(allActual).usingElementComparatorIgnoringFields("menu").isEqualTo(allExpected);
    }

    @Test
    void getWithMenu() {
        Restaurant restWithMenu = repository.getWithMenu(REST_ID);
        Restaurant newRestaurant = getNewRestaurant();
        newRestaurant.setId(REST_ID);
        newRestaurant.setName("VESUVIO");
        newRestaurant.setMenu(VESUVIO_MENU_BY_PRICE);

        assertThat(restWithMenu).isEqualToIgnoringGivenFields(newRestaurant, "menu");
        assertThat(restWithMenu.getMenu())
                .usingRecursiveComparison()
                .ignoringFields("restaurant")
                .isEqualTo(newRestaurant.getMenu());
    }
}