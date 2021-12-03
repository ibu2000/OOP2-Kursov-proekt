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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_idUser",referencedColumnName = "idUser")
    private long USER_idUser;


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

    public long getUSER_idUser() {
        return USER_idUser;
    }

    public void setUSER_idUser(long USER_idUser) {
        this.USER_idUser = USER_idUser;
    }

    @Override
    public String toString() {
        return "LENDBOOKS{" +
                "idLendBook=" + idLendBook +
                ", dateOfTaking=" + dateOfTaking +
                ", USER_idUser=" + USER_idUser +
                '}';
    }
}
