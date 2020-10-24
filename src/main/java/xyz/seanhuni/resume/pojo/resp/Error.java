package xyz.seanhuni.resume.pojo.resp;

import lombok.Data;

@Data
public class Error {
    private String field;
    private String errMsg;
    private String rejectedValue;
}
