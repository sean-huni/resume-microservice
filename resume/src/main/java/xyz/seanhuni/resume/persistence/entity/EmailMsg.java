package xyz.seanhuni.resume.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Objects;

@ToString
@Getter
@Setter
@Entity
@Table(name = "emailMsg", schema = "dr_schema")
public class EmailMsg extends AbstractDomainClass {
    private static final long serialVersionUID = 7526471155622776147L;

    private String name;
    private String subject;
    private String message;
    private LocalDateTime dtSent;

    @ManyToOne(cascade = CascadeType.PERSIST, targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmailMsg)) return false;
        EmailMsg emailMsg = (EmailMsg) o;
        return
//        return Objects.equals(getUserId(), emailMsg.getUserId()) &&
                Objects.equals(getName(), emailMsg.getName()) &&
                        Objects.equals(getSubject(), emailMsg.getSubject()) &&
                        Objects.equals(getMessage(), emailMsg.getMessage()) &&
                        Objects.equals(getDtSent(), emailMsg.getDtSent()) &&
                        Objects.equals(getUser(), emailMsg.getUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getSubject(), getMessage(), getDtSent(), getUser());
    }
}
