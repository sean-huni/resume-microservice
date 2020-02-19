package xyz.seanhuni.resume.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.forms.EmailForm;
import xyz.seanhuni.resume.service.PreprocessService;

import javax.validation.constraints.NotNull;

import static xyz.seanhuni.resume.commons.Constants.REST_V1_ENDPOINT;

@Slf4j
@RestController
@RequestMapping(REST_V1_ENDPOINT + "/send-email")
public class EmailRestCtrl {
    private PreprocessService preprocessService;


    @Autowired
    public void setEmailService(PreprocessService preprocessService) {
        this.preprocessService = preprocessService;
    }

    @PostMapping
    public RespDto sendEmail(@RequestBody @NotNull EmailForm emailForm) {

        return preprocessService.preprocessAndSendEmail(emailForm.getName(), emailForm.getEmail(), emailForm.getSubject(), emailForm.getMessage());
    }
}
