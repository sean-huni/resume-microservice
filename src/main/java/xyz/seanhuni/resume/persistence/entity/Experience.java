package xyz.seanhuni.resume.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "experience", schema = "dr_schema")
public class Experience extends AbstractDomainClass {

    private LocalDateTime dtStart;
    private LocalDateTime dtEnd;
    private String desig;
    private String natow;
    private Boolean currP;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = Responsibility.class)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "experience_id")
    @JoinColumn(name = "experience_id")
    private List<Responsibility> responsibilities = new ArrayList<>();

}