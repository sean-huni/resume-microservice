package xyz.seanhuni.resume.service;

import xyz.seanhuni.resume.exception.EmailException;
import xyz.seanhuni.resume.pojo.resp.RespDto;

public interface EmailProcessService {

    RespDto preprocessAndSendEmail(String uName, String uEmail, String uSubject, String uMessage) throws EmailException;
}
