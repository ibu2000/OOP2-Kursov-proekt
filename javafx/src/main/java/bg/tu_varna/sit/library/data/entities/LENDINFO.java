package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;

@Table(name = "LENDINFO")
@Entity
public class LENDINFO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLendingInfo",nullable = false)
    private long idLendingInfo;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BOOKS_idBook",referencedColumnName = "idBook",nullable = false)
    private Books BOOKS_idBook;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LENDBOOKS_idLendBook",referencedColumnName = "idLendBook",nullable = false)
    private LENDBOOKS LENDBOOKS_idLendBook;


    public long getIdLendingInfo() {
        return idLendingInfo;
    }

    public void setIdLendingInfo(long idLendingInfo) {
        this.idLendingInfo = idLendingInfo;
    }

    public Books getBOOKS_idBook() {
        return BOOKS_idBook;
    }

    public void setBOOKS_idBook(Books BOOKS_idBook) {
        this.BOOKS_idBook = BOOKS_idBook;
    }

    public LENDBOOKS getLENDBOOKS_idLendBook() {
        return LENDBOOKS_idLendBook;
    }

    public void setLENDBOOKS_idLendBook(LENDBOOKS LENDBOOKS_idLendBook) {
        this.LENDBOOKS_idLendBook = LENDBOOKS_idLendBook;
    }

    @Override
    public String toString() {
        return "LENDINFO{" +
                "idLendingInfo=" + idLendingInfo +
                ", BOOKS_idBook=" + BOOKS_idBook +
                ", LENDBOOKS_idLendBook=" + LENDBOOKS_idLendBook +
                '}';
    }
}
