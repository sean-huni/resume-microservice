package xyz.seanhuni.resume.service.impl;

import groovy.util.logging.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.service.PreprocessService;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@SpringBootTest
class PreProcessServiceImplTest {
    private static final Logger log = LoggerFactory.getLogger(PreProcessServiceImplTest.class);
    @Autowired
    private PreprocessService preprocessService;

    @Test
    void preprocessAndSendEmail() {
        final String name = "Sean Huni", email = "seankay@msn.com", subject = "Spring Service Subject Test.", msg = "Message Body Test.";
        RespDto respDto = preprocessService.preprocessAndSendEmail(name, email, subject, msg);

        assertTrue(respDto.isSuccess());
        log.info(respDto::toString);
    }
}