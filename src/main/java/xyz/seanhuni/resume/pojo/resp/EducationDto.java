package xyz.seanhuni.resume.pojo.resp;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class EducationDto {
    private Integer id;
    private LocalDateTime dtStart;
    private LocalDateTime dtEnd;
    private String inst;
    private String loca;
    private Boolean currQ;
    private String qual;
    private String highs;
    private String oGrade;
    private LocalDateTime dtCreated;

}
