package com.example.TwitchBudgetTool;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepo repo;

    // test methods go below
    @Test
    public void testCreateUser() {
        Users user = new Users();
        user.setEmail("test@gmail.com");
        user.setPassword("testpassword");
        user.setFirstName("test");
        user.setLastName("user");

        Users savedUser = repo.save(user);

        Users existUser = entityManager.find(Users.class, savedUser.getId());

        assertThat(user.getEmail()).isEqualTo(existUser.getEmail());

    }
}

