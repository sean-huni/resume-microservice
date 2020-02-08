package xyz.seanhuni.resume.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.service.PreprocessService;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Slf4j
@RestController
@RequestMapping("/send-email")
public class EmailRestCtrl {
    private PreprocessService preprocessService;


    @Autowired
    public void setEmailService(PreprocessService preprocessService) {
        this.preprocessService = preprocessService;
    }

    @PostMapping
    public RespDto sendEmail(@NotNull @Size(max = 45, message = "Your Name should be at most 45 characters")
                             @RequestParam(value = "name") String uName,
                             @NotNull @Email @Size(max = 25, message = "Email should contain at most 25 characters")
                             @RequestParam(value = "email") String uEmail,
                             @Size(max = 75, min = 3, message = "Subject is restricted between 3 to 75 characters")
                             @RequestParam(value = "subject") String uSubject,
                             @Size(max = 900, min = 3, message = "Message is restricted between 3 to 900 characters in length.")
                             @RequestParam(value = "message") String uMessage) {

        return preprocessService.preprocessAndSendEmail(uName, uEmail, uSubject, uMessage);
    }
}
