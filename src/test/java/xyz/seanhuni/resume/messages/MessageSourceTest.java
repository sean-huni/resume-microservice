package xyz.seanhuni.resume.messages;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.MessageSource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MessageSourceTest {

    @Autowired
    private MessageSource messageSource;

    @Test
    void givenMessageSource_whenRetrievingI18nClientMessages_thenFindMessageClientInvalidError() {
        String message = messageSource.getMessage("email.400.101", null, Locale.ENGLISH);
        assertNotNull(message);
        assertEquals("Invalid Request! Failed validation! Please check all the email-fields & try again.", message);
    }

}
