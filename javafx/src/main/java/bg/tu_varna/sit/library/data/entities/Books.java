package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

@Table(name = "books")
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBook",nullable = false)
    private long idBook;

    @Column(name = "bookName", nullable = false)
    private String bookName;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "yearOfPublishing", nullable = false)
    private LocalDate yearOfPublishing;

    public Books()
    {   }

    public Books(String bookName, String author, String genre, LocalDate yearOfPublishing) {
        this.bookName = bookName;
        this.author = author;
        this.genre = genre;
        this.yearOfPublishing = yearOfPublishing;
    }

    public Books(String bookName) {
        this.bookName = bookName;
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
    public String toString() {
        return "Books{" +
                "idBook=" + idBook +
                ", bookName='" + bookName + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", yearOfPublishing=" + yearOfPublishing +
                '}';
    }
}
