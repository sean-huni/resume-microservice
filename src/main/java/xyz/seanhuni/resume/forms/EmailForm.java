package xyz.seanhuni.resume.forms;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class EmailForm {

    @NotNull
    @Size(max = 40, message = "Name should contain at most 40 characters")
    private String name;
    @NotNull
    @Size(max = 75, message = "Subject should contain at most 75 characters")
    private String subject;
    @Size(max = 25, message = "Email should contain at most 25 characters")
    private String email;
    @Size(max = 900, message = "Message should contain at most 900 characters")
    private String message;

}
