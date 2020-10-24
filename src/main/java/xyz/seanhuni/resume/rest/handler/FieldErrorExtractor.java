package xyz.seanhuni.resume.rest.handler;

import org.springframework.validation.FieldError;
import xyz.seanhuni.resume.pojo.resp.Error;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class FieldErrorExtractor {

    List<Error> extractErrorObjects(List<FieldError> fieldErrors) {
        return fieldErrors.stream().map(fieldError -> {
            Error error = new Error();
            error.setField(fieldError.getField());
            error.setRejectedValue(Objects.requireNonNull(fieldError.getRejectedValue()).toString());
            error.setErrMsg(fieldError.getDefaultMessage());
            return error;
        }).collect(Collectors.toList());
    }

}
