package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.Eksemplqri;
import bg.tu_varna.sit.library.data.entities.LENDBOOKS;

import javax.persistence.*;
import java.util.Objects;

public class LendingInfoModel {

    private long idLendInfo;
    private Books BOOKS_idBook;
    private LENDBOOKS LENDBOOKS_idLendBook;
    private Eksemplqri eksemplqri_isbnUnikalenNomer;
    private boolean inChitalnq;

    public LendingInfoModel() {
    }

    public LendingInfoModel(Books BOOKS_idBook, LENDBOOKS LENDBOOKS_idLendBook, Eksemplqri eksemplqri_isbnUnikalenNomer, boolean inChitalnq) {
        this.BOOKS_idBook = BOOKS_idBook;
        this.LENDBOOKS_idLendBook = LENDBOOKS_idLendBook;
        this.eksemplqri_isbnUnikalenNomer = eksemplqri_isbnUnikalenNomer;
        this.inChitalnq = inChitalnq;
    }

    public LendingInfoModel(long idLendInfo, Books BOOKS_idBook, LENDBOOKS LENDBOOKS_idLendBook, Eksemplqri eksemplqri_isbnUnikalenNomer, boolean inChitalnq) {
        this.idLendInfo = idLendInfo;
        this.BOOKS_idBook = BOOKS_idBook;
        this.LENDBOOKS_idLendBook = LENDBOOKS_idLendBook;
        this.eksemplqri_isbnUnikalenNomer = eksemplqri_isbnUnikalenNomer;
        this.inChitalnq = inChitalnq;
    }

    public boolean isInChitalnq() {
        return inChitalnq;
    }
    public void setInChitalnq(boolean inChitalnq) {
        this.inChitalnq = inChitalnq;
    }

    public long getIdLendInfo() {
        return idLendInfo;
    }

    public void setIdLendInfo(long idLendInfo) {
        this.idLendInfo = idLendInfo;
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

    public Eksemplqri getEksemplqri_isbnUnikalenNomer() {
        return eksemplqri_isbnUnikalenNomer;
    }

    public void setEksemplqri_isbnUnikalenNomer(Eksemplqri eksemplqri_isbnUnikalenNomer) {
        this.eksemplqri_isbnUnikalenNomer = eksemplqri_isbnUnikalenNomer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LendingInfoModel)) return false;
        LendingInfoModel that = (LendingInfoModel) o;
        return getIdLendInfo() == that.getIdLendInfo() && isInChitalnq() == that.isInChitalnq() && Objects.equals(getBOOKS_idBook(), that.getBOOKS_idBook()) && Objects.equals(getLENDBOOKS_idLendBook(), that.getLENDBOOKS_idLendBook()) && Objects.equals(getEksemplqri_isbnUnikalenNomer(), that.getEksemplqri_isbnUnikalenNomer());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdLendInfo(), getBOOKS_idBook(), getLENDBOOKS_idLendBook(), getEksemplqri_isbnUnikalenNomer(), isInChitalnq());
    }

    @Override
    public String toString() {
        return "LendingInfoModel{" +
                "idLendingInfo=" + idLendInfo +
                ", BOOKS_idBook=" + BOOKS_idBook +
                ", LENDBOOKS_idLendBook=" + LENDBOOKS_idLendBook +
                ", eksemplqri_isbnUnikalenNomer=" + eksemplqri_isbnUnikalenNomer +
                '}';
    }
}
