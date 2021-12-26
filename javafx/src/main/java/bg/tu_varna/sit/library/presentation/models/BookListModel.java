package bg.tu_varna.sit.library.presentation.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class BookListModel {

    private long idBook;
    private String bookName;
    private String author;
    private String genre;
    private LocalDate yearOfPublishing;

    public BookListModel(long idBook, String bookName, String author, String genre, LocalDate yearOfPublishing) {
        this.idBook = idBook;
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookListModel(String bookName, String author, String genre, LocalDate yearOfPublishing) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.yearOfPublishing = yearOfPublishing;
    }

    public BookListModel(String bookName) {
        this.bookName = bookName;
    }

    public BookListModel() {
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(LocalDate yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookListModel)) return false;
        BookListModel that = (BookListModel) o;
        return getIdBook() == that.getIdBook() && Objects.equals(getBookName(), that.getBookName()) && Objects.equals(getAuthor(), that.getAuthor()) && Objects.equals(getGenre(), that.getGenre()) && Objects.equals(getYearOfPublishing(), that.getYearOfPublishing());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdBook(), getBookName(), getAuthor(), getGenre(), getYearOfPublishing());
    }

    @Override
    public String toString() {
        return "BookListModel{" +
                "idBook=" + idBook +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
