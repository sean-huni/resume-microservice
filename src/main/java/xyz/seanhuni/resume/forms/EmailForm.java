package xyz.seanhuni.resume.forms;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EmailForm {

    @NotNull
    @Size(max = 45, message = "Your Name should be at most 45 characters")
    private String name;
    @NotNull
    @Email
    @Size(max = 75, min = 3, message = "Subject is restricted between 3 to 75 characters")
    private String subject;
    @Size(max = 25, message = "Email should contain at most 25 characters")
    private String email;
    @Size(max = 900, min = 3, message = "Message is restricted between 3 to 900 characters in length.")
    private String message;

}
