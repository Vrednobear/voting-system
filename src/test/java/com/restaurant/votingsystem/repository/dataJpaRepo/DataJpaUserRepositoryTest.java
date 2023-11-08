package com.restaurant.votingsystem.repository.dataJpaRepo;

import com.restaurant.votingsystem.model.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static com.restaurant.votingsystem.TestUtils.*;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = {"classpath:/db/data.sql"})
class DataJpaUserRepositoryTest {

	@Autowired
	DataJpaUserRepository userRepository;

	@Test
	void delete()
	{
		assertThat(userRepository.getAll().size()==2).isTrue();
		assertThat(userRepository.delete(USER_ID)).isTrue();
		assertThat(userRepository.getAll().size()==1).isTrue();
	}

	@Test
	void create() {
		User actual = userRepository.save(getNewUser());
		User expected = getNewUser();
		expected.setId(actual.getId());
		assertThat(actual).isEqualToIgnoringGivenFields(expected,"role");
	}

	@Test
	void update() {
		User updUser = getNewUser();
		updUser.setId(USER_ID);
		updUser.setEmail("updEmail@gmail.com");
		User actual = userRepository.save(updUser);
		assertThat(actual).isEqualToIgnoringGivenFields(updUser,"role");
	}

	@Test
	void get() {
		User userActual = userRepository.get(USER_ID);
		assertThat(userActual).isEqualToIgnoringGivenFields(USER, "roles", "restaurantVotedId");
	}

	@Test
	void getAll() {
		List<User> allActual = userRepository.getAll();
		List<User> allExpected = List.of(ADMIN, USER);
		assertThat(allActual).usingElementComparatorIgnoringFields("roles","restaurantVotedId").isEqualTo(allExpected);
	}
}