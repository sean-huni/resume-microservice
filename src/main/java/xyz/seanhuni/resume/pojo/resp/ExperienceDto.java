package xyz.seanhuni.resume.pojo.resp;

import lombok.Getter;
import lombok.Setter;
import xyz.seanhuni.resume.persistence.entity.Responsibility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ExperienceDto {

    private Integer id;
    private LocalDateTime dtStart;
    private LocalDateTime dtEnd;
    private String desig;
    private String comp;
    private String loca;
    private String natow;
    private Boolean currP;
    private Integer version;
    private LocalDateTime dtUpdated;
    private LocalDateTime dtCreated;

    private List<Responsibility> responsibilities = new ArrayList<>();

}