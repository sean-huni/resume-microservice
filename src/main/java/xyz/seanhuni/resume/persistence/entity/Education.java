package xyz.seanhuni.resume.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "education", schema = "dr_schema")
public class Education extends AbstractDomainClass {
    private LocalDateTime dtStart;
    private LocalDateTime dtEnd;
    private String inst;
    private Boolean currQ;
    private String qual;
    private String highs;
    private String oGrade;

    @Override
    public String toString() {
        return "Education{" +
                "id=" + getId() +
                "dt_start=" + dtStart +
                ", dt_end=" + dtEnd +
                ", inst='" + inst + '\'' +
                ", curr_q=" + currQ +
                ", qual='" + qual + '\'' +
                ", highs='" + highs + '\'' +
                ", o_grade='" + oGrade + '\'' +
                ", dt_created=" + getDtCreated() +
                '}';
    }
}
