package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;

@Table(name = "LENDINFO")
@Entity
public class LENDINFO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLendingInfo",nullable = false)
    private long idLendingInfo;

    @Column(name = "BOOKS_idBook",nullable = false)
    @OneToOne(mappedBy = "idBook")
    private long BOOKS_idBook;


        @Column(name = "LENDBOOKS_idLendBook",nullable = false)
    @OneToOne(mappedBy = "idLendBook")
    private long LENDBOOKS_idLendBook;


    public long getIdLendingInfo() {
        return idLendingInfo;
    }

    public void setIdLendingInfo(long idLendingInfo) {
        this.idLendingInfo = idLendingInfo;
    }

    public long getBOOKS_idBook() {
        return BOOKS_idBook;
    }

    public void setBOOKS_idBook(long BOOKS_idBook) {
        this.BOOKS_idBook = BOOKS_idBook;
    }

    public long getLENDBOOKS_idLendBook() {
        return LENDBOOKS_idLendBook;
    }

    public void setLENDBOOKS_idLendBook(long LENDBOOKS_idLendBook) {
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
