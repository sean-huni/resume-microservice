package xyz.seanhuni.resume.service.impl;

import lombok.extern.slf4j.Slf4j;
import net.sargue.mailgun.Configuration;
import net.sargue.mailgun.Mail;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.service.EmailService;

@Slf4j
@Service
public class MailGunServiceImpl implements EmailService {
    private static final String WEB_MASTER_EMAIL = "sean2kay@gmail.com";
    private static final String DOMAIN = "kudzai.xyz";
    private static final String API_KEY = "key-6e65bd79418406e63c8bbc45e8662fef";

    /**
     * Uses the MailGunImpl Utility to send emails
     * to Sean Huni's account.
     *
     * @param name    Name & Surname of the person sending the email.
     * @param from    The sender's email-address.
     * @param subject The Subject Header of the email message.
     * @param msg     The contents of the email address.
     */
    @Override
    public void sendEmail(String name, String from, String subject, String msg) throws EmailException {
        try {
            sendEmail2nd(name, from, msg, subject);
        } catch (EmailException e) {
            log.error(e.getMessage(), e);
            throw new EmailException(e.getMessage());
        }
    }


    private void sendEmail2nd(String name, String from, String msg, String sbj) throws EmailException {
        try {
            log.info("Configuring MailGunImpl...");
            Configuration configuration = new Configuration(DOMAIN, API_KEY, from);
            log.info("Configuration completed!!!");

            log.info("Sending Mail...");
            Mail.using(configuration)
                    .to(WEB_MASTER_EMAIL)
                    .from(name, from)
                    .subject(sbj)
                    .text(msg)
                    .build()
                    .send();
            log.info("Mail Sent!!!");

        } catch (Exception ex) {
            throw new EmailException(ex.getMessage(), ex);
        }
    }
}
