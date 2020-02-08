package xyz.seanhuni.resume.util.validation;


import xyz.seanhuni.resume.forms.EmailForm;

public class InputDataValidation {
    public EmailForm validator(String name, String subj, String msg) {
        EmailForm valObj = new EmailForm();
        StringFilter filter = new StringFilter();
        valObj.setName(filter.containsIllegals(name) ? filter.cleanIllegals(name) : name);
        valObj.setSubject(filter.containsIllegals(subj) ? filter.cleanIllegals(subj) : subj);
        valObj.setMessage(filter.containsIllegals(msg) ? filter.cleanIllegals(msg) : msg);
        return valObj;
    }
}
