package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Table(name = "FORM")
@Entity
public class FORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForm", nullable = false)
    private long idForm;


    @Column(name = "submitionDate", nullable = false)
    private Date submitionDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    private USER USER_idUser;

    public FORM(long idForm, Date submitionDate, USER USER_idUser) {
        this.idForm = idForm;
        this.submitionDate = submitionDate;
        this.USER_idUser = USER_idUser;
    }

    public FORM() {
    }

    public long getIdForm() {
        return idForm;
    }

    public void setIdForm(long idForm) {
        this.idForm = idForm;
    }

    public Date getSubmitionDate() {
        return submitionDate;
    }

    public void setSubmitionDate(Date submitionDate) {
        this.submitionDate = submitionDate;
    }

    public USER getUSER_idUser() {
        return USER_idUser;
    }

    public void setUSER_idUser(USER USER_idUser) {
        this.USER_idUser = USER_idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FORM)) return false;
        FORM form = (FORM) o;
        return getIdForm() == form.getIdForm() && Objects.equals(getSubmitionDate(), form.getSubmitionDate()) && Objects.equals(getUSER_idUser(), form.getUSER_idUser());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdForm(), getSubmitionDate(), getUSER_idUser());
    }

    @Override
    public String toString() {
        return "FORM{" +
                "idForm=" + idForm +
                ", submitionDate=" + submitionDate +
                ", USER_idUser=" + USER_idUser +
                '}';
    }
}