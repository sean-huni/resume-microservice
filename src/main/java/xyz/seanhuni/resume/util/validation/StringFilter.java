package xyz.seanhuni.resume.util.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFilter {
    private static final Pattern INVALID_CHARS_PATTERN =
            Pattern.compile("^.*[~#@*+%{}<>\\[\\]|\"\\_].*$");
    private static final String ILLEGAL_CHARS = "[~#@*+%{}<>\\[\\]|\"\\_^]";
    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    public StringFilter() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    public Boolean containsIllegals(String toExamine) {
        return INVALID_CHARS_PATTERN.matcher(toExamine).matches();
    }

    public String cleanIllegals(String toExamine) {
//        return toExamine.replaceAll("[~#@*+%{}<>\\[\\]|\"\\_^]", "");
        return toExamine.replaceAll(ILLEGAL_CHARS, "");
    }


    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    public Boolean emailValidator(String hex) {
        matcher = pattern.matcher(hex);
        return matcher.matches();

    }
}