package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "FORM")
@Entity
public class FORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForm", nullable = false)
    private long idForm;

    @OneToOne(mappedBy = "idForm")
    private FORM byUSER;

    @Column(name = "submitionDate", nullable = false)
    private Date submitionDate;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_idUser", referencedColumnName = "idUser")
    private USER USER_idUser;

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
    public String toString() {
        return "FORM{" +
                "idForm=" + idForm +
                ", submitionDate=" + submitionDate +
                ", USER_idUser=" + USER_idUser +
                '}';
    }
}