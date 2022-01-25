package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Table(name = "BOOKSSTORED")
@Entity
public class BOOKSSTORED {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "books_idBook",referencedColumnName = "idBook", nullable = false)
    private long BOOKS_idBook;

    @Column(name = "total")
    private long total;

    @Column(name = "available",nullable = false)
    private long available;

    @Column(name = "chitalnq",nullable = false)
    private long chitalnq;

    public long getBOOKS_idBook() {
        return BOOKS_idBook;
    }

    public void setBOOKS_idBook(long BOOKS_idBook) {
        this.BOOKS_idBook = BOOKS_idBook;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getAvailable() {
        return available;
    }

    public void setAvailable(long available) {
        this.available = available;
    }

    public long getChitalnq() {
        return chitalnq;
    }

    public void setChitalnq(long chitalnq) {
        this.chitalnq = chitalnq;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BOOKSSTORED)) return false;
        BOOKSSTORED that = (BOOKSSTORED) o;
        return getBOOKS_idBook() == that.getBOOKS_idBook() && getTotal() == that.getTotal() && getAvailable() == that.getAvailable() && getChitalnq() == that.getChitalnq();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBOOKS_idBook(), getTotal(), getAvailable(), getChitalnq());
    }

    @Override
    public String toString() {
        return "BOOKSSTORED{" +
                "BOOKS_idBook: " + BOOKS_idBook +
                ", total: " + total +
                ", available: " + available +
                ", chitalnq: " + chitalnq +
                '}';
    }
}
