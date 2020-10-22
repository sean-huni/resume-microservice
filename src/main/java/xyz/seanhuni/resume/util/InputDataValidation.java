package xyz.seanhuni.resume.util;

import xyz.seanhuni.resume.pojo.req.EmailForm;

public interface InputDataValidation {

    /**
     * Clean Strings from malicious attacks.
     *
     * @param maliciousStr suspected string. Guilty until proven innocent.
     * @return clean version of the String.
     */
    String clean(String maliciousStr);

    /**
     * @param email to be probed to check for validity.
     * @return true if the email is in a valid format
     */
    Boolean isValidEmail(String email);


    /**
     * Clean all the literals from malicious attacks.
     *
     * @param name of the sender.
     * @param subj subjects of the email.
     * @param msg  message to be sent vai email.
     * @return clean {@link EmailForm}
     */
    EmailForm validator(String name, String subj, String msg);
}
