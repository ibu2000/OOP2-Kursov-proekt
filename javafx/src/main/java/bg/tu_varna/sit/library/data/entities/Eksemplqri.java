package bg.tu_varna.sit.library.data.entities;
import javax.persistence.*;

@Table(name = "EKSEMPLQRI")
@Entity
public class Eksemplqri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbnUnikalenNomer", nullable = false)
    private long isbnUnikalenNomer;


  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "BOOKS_idBook",referencedColumnName = "books_idBook", nullable = false)
  private Books idBook;

   @OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "STATEOFBOOKS_idState", referencedColumnName = "idState")
   private StateOfBooks exsemplqri_stateOfBooks;

    @Column(name = "isItArchived", nullable = false)
    private boolean isitArchived;

    public Eksemplqri(long isbnUnikalenNomer, Books idBook, StateOfBooks exsemplqri_stateOfBooks, boolean isitArchived) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.idBook = idBook;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
        this.isitArchived = isitArchived;
    }

    public Eksemplqri() {
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


    public StateOfBooks getExsemplqri_stateOfBooks() {
        return exsemplqri_stateOfBooks;
    }

    public void setExsemplqri_stateOfBooks(StateOfBooks exsemplqri_stateOfBooks) {
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
    }

    public boolean isIsitArchived() {
        return isitArchived;
    }

    public void setIsitArchived(boolean isitArchived) {
        this.isitArchived = isitArchived;
    }

    @Override
    public String toString() {
        return "Eksemplqri{" +
                "isbnUnikalenNomer=" + isbnUnikalenNomer +
                ", idBook=" + idBook +
                ", exsemplqri_stateOfBooks=" + exsemplqri_stateOfBooks +
                ", isitArchived=" + isitArchived +
                '}';
    }
}
