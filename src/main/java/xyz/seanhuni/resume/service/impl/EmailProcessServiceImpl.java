package xyz.seanhuni.resume.service.impl;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.commons.Constants;
import xyz.seanhuni.resume.commons.FileReaderService;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.forms.EmailForm;
import xyz.seanhuni.resume.persistence.entity.EmailMsg;
import xyz.seanhuni.resume.persistence.entity.User;
import xyz.seanhuni.resume.persistence.repo.UserRepo;
import xyz.seanhuni.resume.service.EmailProcessService;
import xyz.seanhuni.resume.service.EmailService;
import xyz.seanhuni.resume.util.InputDataValidation;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Log4j2
@Service
public class EmailProcessServiceImpl implements EmailProcessService {
    private final UserRepo userRepo;
    private EmailService emailService;
    private InputDataValidation dataValidation;
    private FileReaderService versionService;

    public EmailProcessServiceImpl(EmailService emailService, UserRepo userRepo, InputDataValidation dataValidation) {
        this.emailService = emailService;
        this.userRepo = userRepo;
        this.dataValidation = dataValidation;
    }

    @Override
    public RespDto preprocessAndSendEmail(String uName, String uEmail, String uSubject, String uMessage) throws EmailException {
        List<String> errors = new ArrayList<>();

        EmailForm valObj = validateEmailForm(uName, uEmail, uSubject, uMessage, errors);

        RespDto emailResp = new RespDto();
        if (errors.size() == 0 && Objects.nonNull(valObj.getEmail()) && !valObj.getEmail().trim().isEmpty()) {
            EmailMsg emailMsg = linkEmailAndSendEmail(valObj);
            emailResp.setRespMsg(emailMsg.getMessage());
            emailResp.setName(emailMsg.getName());
            emailResp.setSuccess(true);
        } else {
            emailResp.setSuccess(false);

            errors.parallelStream().forEach(error -> emailResp.setRespMsg(String.format("%s\n%s", emailResp.getRespMsg(), error)));

            if (!errors.isEmpty()) {
                throw new EmailException(uName, emailResp.getRespMsg());
            }
        }
        return emailResp;
    }

    private EmailMsg linkEmailAndSendEmail(EmailForm valObj) {
        User userP;
        EmailMsg emailMsg = new EmailMsg();

        userP = userRepo.findByUsername(valObj.getEmail());

        if (Objects.isNull(userP)) {
            userP = new User();

            userP.setUsername(valObj.getEmail());
            userP.setEnabled(true);
        }

        userP.setVersion(getVersion());

        emailMsg.setName(valObj.getName());
        emailMsg.setSubject(valObj.getSubject());
        emailMsg.setMessage(valObj.getMessage());

        userP.addNewMsg(emailMsg);
        saveToDBSendEmail(userP, emailMsg);
        return emailMsg;
    }

    private EmailForm validateEmailForm(String uName, String uEmail, String uSubject, String uMessage, List<String> errors) {
        EmailForm valObj = new EmailForm();
        if (uEmail != null) {
            uEmail = uEmail.trim();
        }

        if (uName == null || (uName.trim().length() < 3) || (uName.trim().length() > 255)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_NAME);
        }
        if (uEmail == null || (uEmail.length() < 3) || (uEmail.length() > 255)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_EMAIL);
        }
        if (uSubject == null || (uSubject.trim().length() < 3) || (uSubject.trim().length() > 255)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_SUBJECT);
        }
        if (uMessage == null || (uMessage.trim().length() < 15) || (uMessage.trim().length() > 20_000)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_MESSAGE);
        }

        if (errors.size() == 0) {
            //Validation for the String input values
            valObj = dataValidation.validator(uName, uSubject, uMessage);
        }

        boolean isValidEmail = dataValidation.isValidEmail(uEmail);
        valObj.setEmail(isValidEmail ? uEmail : null);

        if (!isValidEmail) {
            log.error("Invalid email-address!");
            String emailAddressErrorMsg = Objects.isNull(valObj.getEmail()) || valObj.getEmail().trim().isEmpty() ? null : valObj.getEmail().trim();
            emailAddressErrorMsg = Objects.nonNull(emailAddressErrorMsg) ? String.format("%s email address: %s", "Invalid", emailAddressErrorMsg) : String.format("%s email address.", "Invalid");
            errors.add(emailAddressErrorMsg);
        }

        return valObj;
    }

    @Autowired
    public void setVersionService(FileReaderService versionService) {
        this.versionService = versionService;
    }

    private int getVersion() {
        //Set object version
        String ver = versionService.getVersion();
        log.debug("Version: {}", ver);
        int version = Integer.parseInt(ver.replace(".", ""));
        log.info("Integer Parsed Version: " + version);
        return version;
    }

    private void saveToDBSendEmail(User userP, EmailMsg emailMsg) throws EmailException {
        User userResp = userRepo.save(userP);

        //Email function to send email to the user.
//                emailService.sendAsyncMail(userResp.getUsername(), mailTo, mailTo, emailMsg.getSubject(), emailMsg.getMessage());
        emailService.sendEmail(emailMsg.getName(), userResp.getUsername(), emailMsg.getSubject(), emailMsg.getMessage());
    }
}
