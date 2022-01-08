package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.buisness.services.StateofBooksService;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.repositories.BooksRepository;
import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;
import org.apache.log4j.Logger;

import java.time.LocalDate;
import java.util.Objects;

public class ExemplqrModel {


    private long isbnUnikalenNomer;
    private Books idBook;
    private boolean isitArchived;
    private StateOfBooks exsemplqri_stateOfBooks;
    private boolean isitAvailable;
    private LocalDate copyDate;

    public ExemplqrModel(long isbnUnikalenNomer, Books idBook, boolean isitArchived, StateOfBooks exsemplqri_stateOfBooks, boolean isitAvailable, LocalDate copyDate) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.idBook = idBook;
        this.isitArchived = isitArchived;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
        this.isitAvailable = isitAvailable;
        this.copyDate = copyDate;
    }

    public ExemplqrModel() {
    }

    public ExemplqrModel(Books idBook, boolean isitArchived, StateOfBooks exsemplqri_stateOfBooks, boolean isitAvailable, LocalDate copyDate) {
        this.idBook = idBook;
        this.isitArchived = isitArchived;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
        this.isitAvailable = isitAvailable;
        this.copyDate = copyDate;
    }

    public ExemplqrModel(Books idBook, boolean isitArchived, StateOfBooks exsemplqri_stateOfBooks) {
        this.idBook = idBook;
        this.isitArchived = isitArchived;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }


    public ExemplqrModel(long isbnUnikalenNomer,boolean isitArchived, StateOfBooks exsemplqri_stateOfBooks) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.isitArchived = isitArchived;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }

    public ExemplqrModel(long isbnUnikalenNomer, Books idBook, StateOfBooks exsemplqri_stateOfBooks) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.idBook = idBook;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }

    public ExemplqrModel(long isbnUnikalenNomer, Books idBook, boolean isitArchived, StateOfBooks exsemplqri_stateOfBooks) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.idBook = idBook;
        this.isitArchived = isitArchived;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }


    public long getIsbnUnikalenNomer() {
        return isbnUnikalenNomer;
    }

    public void setIsbnUnikalenNomer(long isbnUnikalenNomer) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
    }

    public Books getIdBook() {
        return idBook;
    }

    public void setIdBook(Books idBook) {
        this.idBook = idBook;
    }

    public boolean isIsitArchived() {
        return isitArchived;
    }

    public void setIsitArchived(boolean isitArchived) {
        this.isitArchived = isitArchived;
    }

    public StateOfBooks getExsemplqri_stateOfBooks() {
        return exsemplqri_stateOfBooks;
    }

    public void setExsemplqri_stateOfBooks(StateOfBooks exsemplqri_stateOfBooks) {
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }

    public boolean isIsitAvailable() {
        return isitAvailable;
    }

    public LocalDate getCopyDate() {
        return copyDate;
    }

    public void setCopyDate(LocalDate copyDate) {
        this.copyDate = copyDate;
    }

    public void setIsitAvailable(boolean isitAvailable) {
        this.isitAvailable = isitAvailable;
    }

    @Override
    public String toString() {
        return isbnUnikalenNomer +
                " " + idBook +
                " " + isitArchived +
                " " + exsemplqri_stateOfBooks +
                " " + isitAvailable +
                " " + copyDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ExemplqrModel)) return false;
        ExemplqrModel that = (ExemplqrModel) o;
        return getIsbnUnikalenNomer() == that.getIsbnUnikalenNomer() && isIsitArchived() == that.isIsitArchived() && isIsitAvailable() == that.isIsitAvailable() && Objects.equals(getIdBook(), that.getIdBook()) && Objects.equals(getExsemplqri_stateOfBooks(), that.getExsemplqri_stateOfBooks()) && Objects.equals(getCopyDate(), that.getCopyDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsbnUnikalenNomer(), getIdBook(), isIsitArchived(), getExsemplqri_stateOfBooks(), isIsitAvailable(), getCopyDate());
    }
}
