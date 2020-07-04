package xyz.seanhuni.resume.util.validation;

import org.springframework.stereotype.Component;
import xyz.seanhuni.resume.util.StringFilter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


@Component
public class StringFilterImpl implements StringFilter {
    private static final Pattern INVALID_CHARS_PATTERN =
            Pattern.compile("^.*[~#@*+%{}<>\\[\\]|\"\\_].*$");
    private static final String ILLEGAL_CHARS = "[~#@*+%{}<>\\[\\]|\"\\_^]";
    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    private Pattern pattern;
    private Matcher matcher;

    public StringFilterImpl() {
        pattern = Pattern.compile(EMAIL_PATTERN);
    }

    /**
     * Checks if illegal characters exist.
     *
     * @param toExamine {@link String} to be scanned for illegals.
     * @return true if illegal characters are found.
     */
    public Boolean containsIllegals(String toExamine) {
        return INVALID_CHARS_PATTERN.matcher(toExamine).matches();
    }

    /**
     * Cleans/Removes illegal characters.
     *
     * @param toExamine dirty {@link String} to be cleaned.
     * @return cleaned {@link String} without illegal characters.
     */
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