package xyz.seanhuni.resume.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Entity
@Table(name = "questInfo", schema = "dr_schema")
public class QuestionInfo extends AbstractDomainClass {
    @Column(name = "questAns_id", insertable = false, updatable = false)
    private Integer questAnsId;

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column
    private String bInfo;

}
