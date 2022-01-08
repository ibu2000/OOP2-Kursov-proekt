package bg.tu_varna.sit.library.data.entities;
import javax.persistence.*;
import java.time.LocalDate;

@Table(name = "EKSEMPLQRI")
@Entity
public class Eksemplqri {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "isbnUnikalenNomer", nullable = false)
    private long isbnUnikalenNomer;


  @OneToOne//(cascade = CascadeType.ALL)
  @JoinColumn(name = "books_idBook",referencedColumnName = "idBook", nullable = false)
  private Books idBook;

   @OneToOne//(cascade = CascadeType.ALL)
   @JoinColumn(name = "STATEOFBOOKS_idState", referencedColumnName = "idState")
   private StateOfBooks exsemplqri_stateOfBooks;

    @Column(name = "isItArchived", nullable = false)
    private boolean isitArchived;

    @Column(name = "isitAvailable", nullable = false)
    private boolean isitAvailable;

    @Column(name = "copyDate", nullable = false)
    private LocalDate copyDate;

    public Eksemplqri() {
    }

    public Eksemplqri(long isbnUnikalenNomer, Books idBook, StateOfBooks exsemplqri_stateOfBooks, boolean isitArchived, boolean isitAvailable, LocalDate copyDate) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
        this.idBook = idBook;
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
        this.isitArchived = isitArchived;
        this.isitAvailable = isitAvailable;
        this.copyDate = copyDate;
    }

    public Eksemplqri(long isbnUnikalenNomer) {
        this.isbnUnikalenNomer = isbnUnikalenNomer;
    }

    public Eksemplqri(StateOfBooks exsemplqri_stateOfBooks, boolean isitArchived) {
        this.exsemplqri_stateOfBooks = exsemplqri_stateOfBooks;
        this.isitArchived = isitArchived;
    }

    public boolean isIsitAvailable() {
        return isitAvailable;
    }

    public void setIsitAvailable(boolean isitAvailable) {
        this.isitAvailable = isitAvailable;
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

    public LocalDate getCopyDate() {
        return copyDate;
    }

    public void setCopyDate(LocalDate copyDate) {
        this.copyDate = copyDate;
    }

    @Override
    public String toString() {
        return "Eksemplqri{" +
                "isbnUnikalenNomer=" + isbnUnikalenNomer +
                ", idBook=" + idBook +
                ", exsemplqri_stateOfBooks=" + exsemplqri_stateOfBooks +
                ", isitArchived=" + isitArchived +
                ", isitAvailable=" + isitAvailable +
                ", copyDate=" + copyDate +
                '}';
    }
}
