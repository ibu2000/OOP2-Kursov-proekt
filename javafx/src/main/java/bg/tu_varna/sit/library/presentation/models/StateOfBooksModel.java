package bg.tu_varna.sit.library.presentation.models;

import java.util.Objects;

public class StateOfBooksModel {

    private long idState;
    private String stateOfBooks;

    public StateOfBooksModel(long idState, String stateOfBooks) {
        this.idState = idState;
        this.stateOfBooks = stateOfBooks;
    }

    public StateOfBooksModel(String stateOfBooks) {
        this.stateOfBooks = stateOfBooks;
    }

    public StateOfBooksModel() {
    }

    public long getIdState() {
        return idState;
    }

    public void setIdState(long idState) {
        this.idState = idState;
    }

    public String getStateOfBooks() {
        return stateOfBooks;
    }

    public void setStateOfBooks(String stateOfBooks) {
        this.stateOfBooks = stateOfBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StateOfBooksModel)) return false;
        StateOfBooksModel that = (StateOfBooksModel) o;
        return getIdState() == that.getIdState() && Objects.equals(getStateOfBooks(), that.getStateOfBooks());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdState(), getStateOfBooks());
    }

    @Override
    public String toString() {
        return "StateOfBooksModel{" +
                "idState=" + idState +
                ", stateOfBooks='" + stateOfBooks + '\'' +
                '}';
    }
}
