package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "BOOKS")
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
    private java.util.Date yearOfPublishing;

    @Column(name = "isItArchived", nullable = false)
    private boolean isitArchived;

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

    public java.util.Date getYearOfPublishing() {
        return yearOfPublishing;
    }

    public void setYearOfPublishing(java.util.Date yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public void setYearOfPublishing(Date yearOfPublishing) {
        this.yearOfPublishing = yearOfPublishing;
    }

    public boolean isIsitArchived() {
        return isitArchived;
    }

    public void setIsitArchived(boolean isitArchived) {
        this.isitArchived = isitArchived;
    }

    @Override
    public String toString() {
        return "Books{" +
                "idBook: " + idBook +
                ", bookName: '" + bookName + '\'' +
                ", author: '" + author + '\'' +
                ", genre: '" + genre + '\'' +
                ", yearOfPublishing: " + yearOfPublishing +
                ", isitArchived: " + isitArchived +
                '}';
    }
}
