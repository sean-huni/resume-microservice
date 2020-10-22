package xyz.seanhuni.resume.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@ToString
@Entity
@Table(name = "responsibility", schema = "dr_schema")
public class Responsibility extends AbstractDomainClass implements DomainObject {
    private static final long serialVersionUID = 7526470055622776147L;

    @Getter
    @Setter
    private Integer experience_id;
    @Getter
    @Setter
    @Column(length = 855)
    private String resp;

}
