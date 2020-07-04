package xyz.seanhuni.resume.rest;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.forms.EmailForm;
import xyz.seanhuni.resume.service.PreProcessService;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Locale;

import static xyz.seanhuni.resume.commons.Constants.REST_V1_ENDPOINT;

@Log4j2
@RestController
@RequestMapping(REST_V1_ENDPOINT + "send-email")
public class EmailRestCtrl {
    private final PreProcessService preProcessService;
    private final MessageSource messageSource;

    public EmailRestCtrl(PreProcessService preProcessService, MessageSource messageSource) {
        this.messageSource = messageSource;
        this.preProcessService = preProcessService;
    }

    @PostMapping
    public RespDto sendEmail(@RequestBody @NotNull @Valid EmailForm emailForm) throws EmailException {
        RespDto resp = preProcessService.preprocessAndSendEmail(emailForm.getName(), emailForm.getEmail(), emailForm.getSubject(), emailForm.getMessage());

        String localSuccessResp = messageSource.getMessage("email.201.100", null, Locale.ENGLISH);

        resp.setRespMsg(String.format(localSuccessResp, resp.getName()));
        return resp;
    }
}
