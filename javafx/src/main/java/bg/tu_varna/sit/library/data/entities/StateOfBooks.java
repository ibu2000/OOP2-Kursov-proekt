package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;

@Table(name = "STATEOFBOOKS")
@Entity
public class StateOfBooks {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idState", nullable = false)
    private long idState;

    @Column(name = "stateOfBooks",nullable = false)
    private String stateOfBooks;

    public long getIdState() {
        return idState;
    }

    public void setIdState(long id) {
        this.idState = id;
    }

    public String getStateOfBooks() {
        return stateOfBooks;
    }

    public void setStateOfBooks(String stateOfBooks) {
        this.stateOfBooks = stateOfBooks;
    }

    @Override
    public String toString() {
        return "StateOfBooks{" +
                "idState: " + idState +
                ", stateOfBook: ='" + stateOfBooks + '\'' +
                '}';
    }
}