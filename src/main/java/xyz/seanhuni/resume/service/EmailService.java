package xyz.seanhuni.resume.service;

import xyz.seanhuni.resume.exception.EmailException;

public interface EmailService {

    /**
     * Uses the MailGunImpl Utility to send emails
     * to Sean Huni's account.
     *
     * @param name    Name & Surname of the person sending the email.
     * @param from    The sender's email-address.
     * @param subject The Subject Header of the email message.
     * @param msg     The contents of the email address.
     */
    void sendEmail(String name, String from, String subject, String msg) throws EmailException;
}