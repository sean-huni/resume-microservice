package xyz.seanhuni.resume.service.impl;


import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.service.EmailService;
import xyz.seanhuni.resume.service.PreProcessService;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@Log4j2
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PreProcessServiceImplTest {
    @MockBean
    private EmailService emailService;

    @Autowired
    private PreProcessService preprocessService;

    @BeforeEach
    void setUp() {
        doNothing().when(emailService).sendEmail(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    void givenPreprocessService_whenSendingEmail_thenSucceed() {
        String name = "Sean Huni", email = "seankay@msn.com", subject = "Spring Service Subject Test.", msg = "Message Body Test.";
        RespDto respDto = preprocessService.preprocessAndSendEmail(name, email, subject, msg);

        assertTrue(respDto.isSuccess());
        log.info(respDto::toString);
        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    void givenPreprocessService_whenSendingEmail_withNameAndSubjectErrors_thenThrowException() {
        String expectedNameErrorMsg = "'Name' must be between 3 & 255 characters long.";
        String name = "S", email = "seankay_msn.com", subject = "Spring)&^&&$%%^$$#%$@%#@!@#$%^&*()_|}{:?><", msg = "}{POK:LH+-**/+/*+/}{:?><+_)(*&^~!@#$%^&*";
        Exception exception = assertThrows(EmailException.class, () -> preprocessService.preprocessAndSendEmail(name, email, subject, msg));
        log.error(exception);
        assertTrue(exception.getMessage().contains(expectedNameErrorMsg));
//        verify(emailService, times(1)).sendEmail(anyString(), anyString(), anyString(), anyString());
    }

    @Test
    void givenPreprocessService_whenSendingEmail_withErrors_thenThrowException() {
        String expectedEmailErrorMsg = "Invalid email address.";
        String name = "Sean Huni", email = "seankay_msn.com", subject = "Spring Service Subject Test.", msg = "Message Body Test.";
        Exception exception = assertThrows(EmailException.class, () -> preprocessService.preprocessAndSendEmail(name, email, subject, msg));

        assertTrue(exception.getMessage().contains(expectedEmailErrorMsg));

    }

}