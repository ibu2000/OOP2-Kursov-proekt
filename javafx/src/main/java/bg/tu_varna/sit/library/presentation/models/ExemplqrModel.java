package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.buisness.services.StateofBooksService;
import bg.tu_varna.sit.library.data.entities.Books;
import bg.tu_varna.sit.library.data.entities.StateOfBooks;
import bg.tu_varna.sit.library.data.repositories.BooksRepository;
import bg.tu_varna.sit.library.data.repositories.EksemplqriRepository;
import bg.tu_varna.sit.library.data.repositories.StateOfBooksRepository;
import org.apache.log4j.Logger;

import java.util.Objects;

public class ExemplqrModel {


    private long isbnUnikalenNomer;
    private Books idBook;
    private boolean isitArchived;
    private StateOfBooks exsemplqri_stateOfBooks;
    private boolean isitAvailable;

    public ExemplqrModel(long isbnUnikalenNomer, Books idBook, boolean isitArchived, StateOfBooks exsemplqri_stateOfBooks, boolean isitAvailable) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.idBook = idBook;
        this.isitArchived = isitArchived;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
        this.isitAvailable = isitAvailable;
    }

    public ExemplqrModel() {
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

    public void setIsitAvailable(boolean isitAvailable) {
        this.isitAvailable = isitAvailable;
    }

    @Override
    public String toString() {
        return "ExemplqrModel{" +
                "isbnUnikalenNomer=" + isbnUnikalenNomer +
                ", idBook=" + idBook +
                ", isitArchived=" + isitArchived +
                ", exsemplqri_stateOfBooks=" + exsemplqri_stateOfBooks +
                ", isitAvailable=" + isitAvailable +
                '}';
    }

    /*
          @Override
            public String toString()
            {
                return  isbnUnikalenNomer +""+ idBook.getBookName() + "" + exsemplqri_stateOfBooks.getStateOfBooks() + "" + isitAvailable;
            }
     */


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExemplqrModel that = (ExemplqrModel) o;
        return isbnUnikalenNomer == that.isbnUnikalenNomer && isitArchived == that.isitArchived && isitAvailable == that.isitAvailable && Objects.equals(idBook, that.idBook) && Objects.equals(exsemplqri_stateOfBooks, that.exsemplqri_stateOfBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbnUnikalenNomer, idBook, isitArchived, exsemplqri_stateOfBooks, isitAvailable);
    }
}
