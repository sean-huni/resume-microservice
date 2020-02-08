package xyz.seanhuni.resume.persistence.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@Entity
@Table(name = "user", schema = "dr_schema")
public class User extends AbstractDomainClass {

    @Column(name = "username", nullable = false)
    private String username;
    private Boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", orphanRemoval = true, fetch = FetchType.EAGER)
    private List<EmailMsg> emailMsg = new ArrayList<>();

    public void addNewMsg(EmailMsg msg) {
        emailMsg.add(msg);
        msg.setUser(this);
    }

    public void deleteEmailMsg(int msgIndex) {
        this.emailMsg.remove(msgIndex);
        this.setEmailMsg(emailMsg);
        emailMsg.forEach(msg -> msg.setUser(this));
    }

}