package com.example.TwitchBudgetTool;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.TwitchBudgetTool.Streams.StreamRepo;
import com.example.TwitchBudgetTool.Streams.Streams;
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
public class StreamRepoCreateStream {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StreamRepo repo;

    // test methods go below
    @Test
    public void testCreateStream() {
        Streams stream = new Streams();
        stream.setDay("Monday");
        stream.setTime("12:00:00");
        stream.setEarnings(75.39);



        Streams savedStream = repo.save(stream);
        Streams existStream = entityManager.find(Streams.class, savedStream.getId());




    }
}

