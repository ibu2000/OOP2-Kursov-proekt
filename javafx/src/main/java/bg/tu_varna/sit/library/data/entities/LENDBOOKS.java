package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "LENDBOOKS")
@Entity
public class LENDBOOKS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLendBook",nullable = false)
    private long idLendBook;

    @Column(name = "dateOfTaking",nullable = false)
    private Date dateOfTaking;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    private USER USER_idUser;

    @Column(name = "dateOfReturn",nullable = false)
    private Date dateOfreturn;


    public Date getDateOfreturn() {
        return dateOfreturn;
    }

    public void setDateOfreturn(Date dateOfreturn) {
        this.dateOfreturn = dateOfreturn;
    }

    public LENDBOOKS(long idLendBook, Date dateOfTaking, USER USER_idUser, Date dateOfreturn) {
        this.idLendBook = idLendBook;
        this.dateOfTaking = dateOfTaking;
        this.USER_idUser = USER_idUser;
        this.dateOfreturn = dateOfreturn;
    }

    public LENDBOOKS() {
    }

    public long getIdLendBook() {
        return idLendBook;
    }

    public void setIdLendBook(long idLendBook) {
        this.idLendBook = idLendBook;
    }

    public Date getDateOfTaking() {
        return dateOfTaking;
    }

    public void setDateOfTaking(Date dateOfTaking) {
        this.dateOfTaking = dateOfTaking;
    }

    public USER getUSER_idUser() {
        return USER_idUser;
    }

    public void setUSER_idUser(USER USER_idUser) {
        this.USER_idUser = USER_idUser;
    }

    @Override
    public String toString() {
        return "LENDBOOKS{" +
                "idLendBook=" + idLendBook +
                ", dateOfTaking=" + dateOfTaking +
                ", USER_idUser=" + USER_idUser +
                ", dateOfreturn=" + dateOfreturn +
                '}';
    }
}
