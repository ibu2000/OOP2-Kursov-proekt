package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;

@Table(name = "LENDINFO")
@Entity
public class LENDINFO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLendingInfo",nullable = false)
    private long idLendingInfo;


    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_idBook",referencedColumnName = "idBook",nullable = false)
    private Books BOOKS_idBook;


    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "lendingbooks_idLendBook",referencedColumnName = "idLendBook",nullable = false)
    private LENDBOOKS LENDBOOKS_idLendBook;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "eksemplqri_isbnUnikalenNomer",referencedColumnName = "isbnUnikalenNomer",nullable = false)
    private Eksemplqri eksemplqri_isbnUnikalenNomer;

    @Column(name = "inChitalnq",nullable = false)
    private boolean inChitalnq;


    public LENDINFO() {
    }

    public LENDINFO(Books BOOKS_idBook, LENDBOOKS LENDBOOKS_idLendBook, Eksemplqri eksemplqri_isbnUnikalenNomer, boolean inChitalnq) {
        this.BOOKS_idBook = BOOKS_idBook;
        this.LENDBOOKS_idLendBook = LENDBOOKS_idLendBook;
        this.eksemplqri_isbnUnikalenNomer = eksemplqri_isbnUnikalenNomer;
        this.inChitalnq = inChitalnq;
    }

    public Eksemplqri getEksemplqri_isbnUnikalenNomer() {
        return eksemplqri_isbnUnikalenNomer;
    }

    public void setEksemplqri_isbnUnikalenNomer(Eksemplqri eksemplqri_isbnUnikalenNomer) {
        this.eksemplqri_isbnUnikalenNomer = eksemplqri_isbnUnikalenNomer;
    }

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

    public boolean isInChitalnq() {
        return inChitalnq;
    }

    public void setInChitalnq(boolean inChitalnq) {
        this.inChitalnq = inChitalnq;
    }

    @Override
    public String toString() {
        return "LENDINFO{" +
                "idLendingInfo=" + idLendingInfo +
                ", BOOKS_idBook=" + BOOKS_idBook +
                ", LENDBOOKS_idLendBook=" + LENDBOOKS_idLendBook +
                ", eksemplqri_isbnUnikalenNomer=" + eksemplqri_isbnUnikalenNomer +
                ", inChitalnq=" + inChitalnq +
                '}';
    }
}
