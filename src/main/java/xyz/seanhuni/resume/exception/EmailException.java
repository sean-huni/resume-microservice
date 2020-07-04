package xyz.seanhuni.resume.exception;

import lombok.Getter;
import lombok.Setter;

public class EmailException extends RuntimeException {
    @Getter
    @Setter
    private String name;

    public EmailException(String message) {
        super(message);
    }

    /**
     * Constructs a new runtime exception with the specified detail message.
     * The cause is not initialized, and may subsequently be initialized by a
     * call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public EmailException(String name, String message) {
        super(message);
        this.name = name;
    }

    public EmailException(String message, Throwable cause) {
        super(message, cause);
    }
}
