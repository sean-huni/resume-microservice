package xyz.seanhuni.resume.dto;

import lombok.Data;

@Data
public class Error {
    private String field;
    private String errMsg;
    private String rejectedValue;
}
