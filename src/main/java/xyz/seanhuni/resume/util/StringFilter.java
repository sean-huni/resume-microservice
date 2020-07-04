package xyz.seanhuni.resume.util;

public interface StringFilter {

    /**
     * Checks if illegal characters exist.
     *
     * @param toExamine {@link String} to be scanned for illegals.
     * @return true if illegal characters are found.
     */
    Boolean containsIllegals(String toExamine);

    /**
     * Cleans/Removes illegal characters.
     *
     * @param toExamine dirty {@link String} to be cleaned.
     * @return cleaned {@link String} without illegal characters.
     */
    String cleanIllegals(String toExamine);

    /**
     * Validate hex with regular expression
     *
     * @param hex hex for validation
     * @return true valid hex, false invalid hex
     */
    Boolean emailValidator(String hex);
}
