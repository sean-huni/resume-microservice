package xyz.seanhuni.resume.persistence.repo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import xyz.seanhuni.resume.persistence.entity.Education;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;


@SpringBootTest
class EducationRepoTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(EducationRepoTest.class);
    @Autowired
    private EducationRepo educationRepo;

    @BeforeEach
    void setUp() {
        LOGGER.debug(() -> "Executing new test");
    }

    @AfterEach
    void tearDown() {
        LOGGER.debug(() -> "Finished previous test");
    }

    @Test
    @Sql({"classpath:data/data.sql"})
    void givenEducationRepo_returnRecordsInTable() {
        List<Education> education = educationRepo.findAll();

        assertNotNull(education);
        assertTrue(education.size() > 0);
    }
}