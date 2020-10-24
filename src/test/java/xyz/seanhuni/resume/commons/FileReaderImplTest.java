package xyz.seanhuni.resume.commons;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class FileReaderImplTest {
    @Autowired
    private FileReaderService readerService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void givenFileReaderService_whenRetrievingResource_thenReturnVersionString() {
        final String version = "5.0.7";

        assertEquals(version, readerService.getVersion());

    }
}