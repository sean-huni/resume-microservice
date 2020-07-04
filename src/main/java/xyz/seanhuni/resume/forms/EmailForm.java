package xyz.seanhuni.resume.forms;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static xyz.seanhuni.resume.commons.Constants.CSTM_EXC_VIEW_FLD_EMAIL;
import static xyz.seanhuni.resume.commons.Constants.CSTM_EXC_VIEW_FLD_MESSAGE;
import static xyz.seanhuni.resume.commons.Constants.CSTM_EXC_VIEW_FLD_NAME;
import static xyz.seanhuni.resume.commons.Constants.CSTM_EXC_VIEW_FLD_SUBJECT;

@Data
@Validated
public class EmailForm {

    @NotNull
    @Size(max = 255, min = 3, message = CSTM_EXC_VIEW_FLD_NAME)
    private String name;
    @NotNull
    @Size(max = 255, min = 3, message = CSTM_EXC_VIEW_FLD_SUBJECT)
    private String subject;
    @Email
    @NotNull
    @Size(max = 255, min = 3, message = CSTM_EXC_VIEW_FLD_EMAIL)
    private String email;
    @NotNull
    @Size(max = 20_000, min = 15, message = CSTM_EXC_VIEW_FLD_MESSAGE)
    private String message;

}
