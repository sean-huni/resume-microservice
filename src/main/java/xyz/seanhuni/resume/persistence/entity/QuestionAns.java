package xyz.seanhuni.resume.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "questAns", schema = "dr_schema")
public class QuestionAns extends AbstractDomainClass {
    private static final long serialVersionUID = 7526471155622776147L;

    private String quest;
    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Column
    private String ans;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true, targetEntity = QuestionInfo.class)
    @PrimaryKeyJoinColumn(name = "id", referencedColumnName = "questAns_id")
    @JoinColumn(name = "questAns_id")
    private List<QuestionInfo> questionInfoList = new ArrayList<>();

}
