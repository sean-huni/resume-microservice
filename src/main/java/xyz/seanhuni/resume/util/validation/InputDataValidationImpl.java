package xyz.seanhuni.resume.util.validation;


import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.forms.EmailForm;
import xyz.seanhuni.resume.util.InputDataValidation;
import xyz.seanhuni.resume.util.StringFilter;

@Component
public class InputDataValidationImpl implements InputDataValidation {
    private StringFilter filter;

    public InputDataValidationImpl(StringFilter filter) {
        this.filter = filter;
    }

    /**
     * Clean all the literals from malicious attacks.
     *
     * @param name of the sender.
     * @param subj subjects of the email.
     * @param msg  message to be sent vai email.
     * @return clean {@link EmailForm}
     */
    public EmailForm validator(String name, String subj, String msg) {
        EmailForm valObj = new EmailForm();
        valObj.setName(filter.containsIllegals(name) ? filter.cleanIllegals(name) : name);
        valObj.setSubject(filter.containsIllegals(subj) ? filter.cleanIllegals(subj) : subj);
        valObj.setMessage(filter.containsIllegals(msg) ? filter.cleanIllegals(msg) : msg);
        return valObj;
    }

    /**
     * Clean Strings from malicious attacks.
     *
     * @param maliciousStr suspected string. Guilty until proven innocent.
     * @return clean version of the String.
     */
    public String clean(String maliciousStr) {
        return filter.containsIllegals(maliciousStr) ? filter.cleanIllegals(maliciousStr) : maliciousStr;
    }

    /**
     * @param email to be probed to check for validity.
     * @return true if the email is in a valid format
     */
    public Boolean isValidEmail(String email) {
        return filter.emailValidator(email);
    }

}
