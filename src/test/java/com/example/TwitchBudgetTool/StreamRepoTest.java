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
public class StreamRepoTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StreamRepo repo;

    // test methods go below
    @Test
    public void testCreateStream() {
        Streams stream = new Streams();
        stream.setDay("Thursday");
        stream.setTime("10:00:00");
        stream.setEarnings(54.13);



        Streams savedStream = repo.save(stream);
        Streams existStream = entityManager.find(Streams.class, savedStream.getId());




    }
}

