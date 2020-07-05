package xyz.seanhuni.resume.rest.handler;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.exception.EmailException;

import java.time.LocalDateTime;
import java.util.Locale;

@Log4j2
@RestControllerAdvice
public class EmailExceptionHandler {
    private static final Locale locale = Locale.UK;
    private final MessageSource messageSource;

    public EmailExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(EmailException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseEntity<RespDto> handleEmailException(EmailException emailException) {
        String emailErrorResp = messageSource.getMessage("email.400.100", null, locale);
        emailErrorResp = String.format(emailErrorResp, emailException.getName());
        log.error(emailErrorResp);
        log.error(emailException.getMessage(), emailException);
        RespDto cer = new RespDto(emailException.getName(), false, emailErrorResp, null, LocalDateTime.now());
        log.debug("Error Response: {}", cer);
        return new ResponseEntity<>(cer, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ResponseEntity<RespDto> invalidInputHandler(MethodArgumentNotValidException invalidException) {
        String emailErrorResp = messageSource.getMessage("email.400.101", null, locale);
        emailErrorResp = String.format("%s", emailErrorResp);
        RespDto resp = new RespDto(null, false, emailErrorResp, new FieldErrorExtractor().extractErrorObjects(invalidException.getBindingResult().getFieldErrors()), LocalDateTime.now());
        return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
    }
}
