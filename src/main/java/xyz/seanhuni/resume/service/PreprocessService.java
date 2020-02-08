package xyz.seanhuni.resume.service;

import xyz.seanhuni.resume.dto.RespDto;

public interface PreprocessService {

    RespDto preprocessAndSendEmail(String uName, String uEmail, String uSubject, String uMessage);
}
