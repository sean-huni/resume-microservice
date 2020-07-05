package xyz.seanhuni.resume.service;

import xyz.seanhuni.resume.dto.RespDto;
import xyz.seanhuni.resume.exception.EmailException;

public interface EmailProcessService {

    RespDto preprocessAndSendEmail(String uName, String uEmail, String uSubject, String uMessage) throws EmailException;
}
