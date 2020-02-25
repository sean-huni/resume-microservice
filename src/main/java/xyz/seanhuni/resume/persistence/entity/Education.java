package xyz.seanhuni.resume.persistence.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@ToString
@Table(name = "education", schema = "dr_schema")
public class Education extends AbstractDomainClass {
    private LocalDateTime dtStart;
    private LocalDateTime dtEnd;
    private String inst;
    private String loca;
    private Boolean currQ;
    private String qual;
    private String highs;
    private String oGrade;

}
