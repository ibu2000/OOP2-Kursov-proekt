package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

@Table(name = "FORM")
@Entity
public class FORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForm", nullable = false)
    private long idForm;


    @Column(name = "submitionDate", nullable = false)
    private LocalDate submitionDate;


    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    private USER USER_idUser;

    @Column(name = "content", nullable = false)
    private String content;

    public FORM() {
    }

    public FORM(long idForm, LocalDate submitionDate, USER USER_idUser, String content) {
        this.idForm = idForm;
        this.submitionDate = submitionDate;
        this.USER_idUser = USER_idUser;
        this.content = content;
    }

    public FORM(LocalDate submitionDate, USER USER_idUser, String content) {
        this.submitionDate = submitionDate;
        this.USER_idUser = USER_idUser;
        this.content = content;
    }

    public long getIdForm() {
        return idForm;
    }

    public void setIdForm(long idForm) {
        this.idForm = idForm;
    }

    public LocalDate getSubmitionDate() {
        return submitionDate;
    }

    public void setSubmitionDate(LocalDate submitionDate) {
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "FORM{" +
                "idForm=" + idForm +
                ", submitionDate=" + submitionDate +
                ", USER_idUser=" + USER_idUser +
                ", content='" + content + '\'' +
                '}';
    }
}