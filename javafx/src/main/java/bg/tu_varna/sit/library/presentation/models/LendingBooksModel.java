package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.data.entities.USER;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;

public class LendingBooksModel {


    private long idLendBook;
    private LocalDate dateOfTaking;
    private USER USER_idUser;
    private LocalDate dateOfreturn;

    public LendingBooksModel() {
    }

    public LendingBooksModel(LocalDate dateOfTaking, USER USER_idUser, LocalDate dateOfreturn) {
        this.dateOfTaking = dateOfTaking;
        this.USER_idUser = USER_idUser;
        this.dateOfreturn = dateOfreturn;
    }

    public LendingBooksModel(long idLendBook, LocalDate dateOfTaking, USER USER_idUser, LocalDate dateOfreturn) {
        this.idLendBook = idLendBook;
        this.dateOfTaking = dateOfTaking;
        this.USER_idUser = USER_idUser;
        this.dateOfreturn = dateOfreturn;
    }

    public long getIdLendBook() {
        return idLendBook;
    }

    public void setIdLendBook(long idLendBook) {
        this.idLendBook = idLendBook;
    }

    public LocalDate getDateOfTaking() {
        return dateOfTaking;
    }

    public void setDateOfTaking(LocalDate dateOfTaking) {
        this.dateOfTaking = dateOfTaking;
    }

    public USER getUSER_idUser() {
        return USER_idUser;
    }

    public void setUSER_idUser(USER USER_idUser) {
        this.USER_idUser = USER_idUser;
    }

    public LocalDate getDateOfreturn() {
        return dateOfreturn;
    }

    public void setDateOfreturn(LocalDate dateOfreturn) {
        this.dateOfreturn = dateOfreturn;
    }

    @Override
    public String toString() {
        return "LendingBooksModel{" +
                "idLendBook=" + idLendBook +
                ", dateOfTaking=" + dateOfTaking +
                ", USER_idUser=" + USER_idUser +
                ", dateOfreturn=" + dateOfreturn +
                '}';
    }
}
