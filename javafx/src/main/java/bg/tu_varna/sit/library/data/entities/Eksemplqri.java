package bg.tu_varna.sit.library.data.entities;
import javax.persistence.*;

@Table(name = "EKSEMPLQRI")
@Entity
public class Eksemplqri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbnUnikalenNomer", nullable = false)
    private long isbnUnikalenNomer;

    @Column(name = "BOOKS_idBook", nullable = false)
    @OneToOne(mappedBy = "id_Book")
    private long idBook;

    @Column(name = "STATEOFBOOKS_idState", nullable = false)
    @OneToOne(mappedBy = "idState")
    private String exsemplqri_stateOfBooks;

    public long getIsbnUnikalenNomer() {
        return isbnUnikalenNomer;
    }

    public void setIsbnUnikalenNomer(long isbnUnikalenNomer) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
    }

    public long getIdBook() {
        return idBook;
    }

    public void setIdBook(long idBook) {
        this.idBook = idBook;
    }

    public String getExsemplqri_stateOfBooks() {
        return exsemplqri_stateOfBooks;
    }

    public void setExsemplqri_stateOfBooks(String exsemplqri_stateOfBooks) {
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }

    @Override
    public String toString() {
        return "Eksemplqri{" +
                "isbnUnikalenNomer: " + isbnUnikalenNomer +
                ", idBook: " + idBook +
                ", exsemplqri_stateOfBooks: '" + exsemplqri_stateOfBooks + '\'' +
                '}';
    }
}
