package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Table(name = "LENDBOOKS")
@Entity
public class LENDBOOKS {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLendBook",nullable = false)
    private long idLendBook;

    @Column(name = "dateOfTaking",nullable = false)
    private LocalDate dateOfTaking;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    private USER USER_idUser;

    @Column(name = "dateOfReturn",nullable = false)
    private LocalDate dateOfreturn;


    public LENDBOOKS(long idLendBook) {
        this.idLendBook = idLendBook;
    }

    public LocalDate getDateOfreturn() {
        return dateOfreturn;
    }

    public void setDateOfreturn(LocalDate dateOfreturn) {
        this.dateOfreturn = dateOfreturn;
    }

    public LENDBOOKS(long idLendBook, LocalDate dateOfTaking, USER USER_idUser, LocalDate dateOfreturn) {
        this.idLendBook = idLendBook;
        this.dateOfTaking = dateOfTaking;
        this.USER_idUser = USER_idUser;
        this.dateOfreturn = dateOfreturn;
    }

    public LENDBOOKS(LocalDate dateOfTaking, USER USER_idUser, LocalDate dateOfreturn) {
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

    public LocalDate getDateOfTaking() {
        return dateOfTaking;
    }

    public void setDateOfTaking(LocalDate dateOfTaking) {
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
        return  idLendBook +"";
    }
}
