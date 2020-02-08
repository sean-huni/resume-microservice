package xyz.seanhuni.resume.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import xyz.seanhuni.resume.commons.Constants;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.forms.EmailForm;
import xyz.seanhuni.resume.persistence.entity.EmailMsg;
import xyz.seanhuni.resume.persistence.entity.User;
import xyz.seanhuni.resume.persistence.repo.UserRepo;
import xyz.seanhuni.resume.service.EmailService;
import xyz.seanhuni.resume.service.PreprocessService;
import xyz.seanhuni.resume.util.validation.InputDataValidation;
import xyz.seanhuni.resume.util.validation.StringFilter;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class PreProcessServiceImpl implements PreprocessService {
    private static String VERSION;
    private EmailService emailService;
    private UserRepo userRepo;

    public PreProcessServiceImpl(EmailService emailService, UserRepo userRepo) {
        this.emailService = emailService;
        this.userRepo = userRepo;
    }

    @Override
    public RespDto preprocessAndSendEmail(String uName, String uEmail, String uSubject, String uMessage) {

        EmailForm valObj;
        if (uEmail != null) {
            uEmail = uEmail.trim();
        }

        RespDto emailResp = new RespDto();

        InputDataValidation dataValidation = new InputDataValidation();
        StringFilter filter = new StringFilter();
        List<String> errors = new ArrayList<>();
        if (uName == null || (uName.trim().length() < 3) || (uName.trim().length() > 25)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_NAME);
        }
        if (uEmail == null || (uEmail.length() < 3) || (uEmail.length() > 75)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_EMAIL);
        }
        if (uSubject == null || (uSubject.trim().length() < 3) || (uSubject.trim().length() > 75)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_SUBJECT);
        }
        if (uMessage == null || (uMessage.trim().length() < 3) || (uMessage.trim().length() > 2000)) {
            errors.add(Constants.CSTM_EXC_VIEW_FLD_MESSAGE);
        }

        //Validation for the String input values
        valObj = dataValidation.validator(uName, uSubject, uMessage);

        valObj.setEmail(filter.emailValidator(uEmail) ? uEmail : null);
        try {
            if (valObj.getEmail() == null || valObj.getEmail().trim().equals(""))
                throw new EmailException("Null Email Address. Email failed validation!");
        } catch (EmailException npe) {
            log.warn("Empty email-address Field!", npe);
            if (uEmail == null || uEmail.trim().equals("")) {
                errors.add(String.format("%s email address.", "Invalid"));
            }
        }


        if (errors.size() == 0) {
            User userP, userResp;
            EmailMsg emailMsg = new EmailMsg();
            List<EmailMsg> emailMsgList;

            userP = userRepo.findByUsername(valObj.getEmail());

            if (null == userP) {
                userP = new User();
                emailMsgList = new ArrayList<>();

                userP.setUsername(valObj.getEmail());
                userP.setEnabled(true);
            } else {
                emailMsgList = userP.getEmailMsg();
            }

            log.info("Application Version: " + VERSION);

            try {
                int version = Integer.parseInt(VERSION.replaceAll(".", ""));
                log.info("Integer Parsed Version: " + version);
                userP.setVersion(version);
            } catch (Exception nfe) {
                log.warn(nfe.getMessage());
                userP.setVersion(300);
            }

            emailMsg.setName(valObj.getName());
            emailMsg.setSubject(valObj.getSubject());
            emailMsg.setMessage(valObj.getMessage());

            userP.addNewMsg(emailMsg);


            //Email function here!!!
            try {
                userResp = userRepo.save(userP);

                //Email function to send email to the user.
//                emailService.sendAsyncMail(userResp.getUsername(), mailTo, mailTo, emailMsg.getSubject(), emailMsg.getMessage());
                emailService.sendEmail(emailMsg.getName(), userResp.getUsername(), emailMsg.getSubject(), emailMsg.getMessage());
                emailResp.setSuccess(true);
            } catch (EmailException e) {
                e.printStackTrace();
                log.error(e.getMessage(), e);
                emailResp.setSuccess(false);
                emailResp.setRespMsg(e.getMessage());
            }

            //Sent the response here.
            if (emailResp.isSuccess()) {
                emailResp.setRespMsg(String.format("Thank you %s! Your email has been sent successfully." +
                        "\n\nSean normally replies within 3hrs.", valObj.getName()));
            } else {
                String warnMsg = "Email sent with warnings.";
                log.warn(warnMsg);
                emailResp.setRespMsg(warnMsg);
            }
        } else {
            emailResp.setSuccess(false);
            boolean aBoolean = false;
            for (String error : errors) {
                emailResp.setRespMsg(aBoolean ? String.format("%s\n%s", emailResp.getRespMsg(), error) : String.format("%s", error));
                aBoolean = true;
            }
        }
        return emailResp;
    }
}
