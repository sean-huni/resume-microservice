package xyz.seanhuni.resume.commons;

public class Constants {
    public static final String REST_V1_ENDPOINT = "api/v1/";

    //   Constants for Custom Exceptions
    public static final String CSTM_EXC_VIEW_FLD_NAME = "'Name' must be between 3 & 255 characters long.";
    public static final String CSTM_EXC_VIEW_FLD_EMAIL = "'Email' must be between 3 & 255 characters long.";
    public static final String CSTM_EXC_VIEW_FLD_SUBJECT = "'Subject', must be between 3 & 255 characters long.";
    public static final String CSTM_EXC_VIEW_FLD_MESSAGE = "'Message', Must be between 15 & 20 000 characters long.";


    private Constants() throws IllegalAccessException {
        throw new IllegalAccessException("Instantiation not permitted!!!");
    }
}
