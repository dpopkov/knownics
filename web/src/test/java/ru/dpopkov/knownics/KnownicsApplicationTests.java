package ru.dpopkov.knownics;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles(Profiles.REPOSITORY_JPA)
//@ActiveProfiles(Profiles.REPOSITORY_MAP)
@SpringBootTest
class KnownicsApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("This test is just checking context loading");
    }

}
