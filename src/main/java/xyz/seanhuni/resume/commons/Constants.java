package xyz.seanhuni.resume.commons;

public class Constants {
    public static final String REST_V1_ENDPOINT = "api/v1/";

    //   Constants for Custom Exceptions
    public static final String CSTM_EXC_VIEW_FLD_NAME = "'Name' must be between 3 & 45 characters long in the.";
    public static final String CSTM_EXC_VIEW_FLD_EMAIL = "'Email' must be between 3 & 25 characters long.";
    public static final String CSTM_EXC_VIEW_FLD_SUBJECT = "'Subject', must be between 3 & 75 characters long.";
    public static final String CSTM_EXC_VIEW_FLD_MESSAGE = "'Message', Must be between 3 & 2000 characters long.";


    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException("Instantiation not permitted!!!");
    }
}
