package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.Status;
import bg.tu_varna.sit.library.data.entities.UserType;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

public class UserListModel {

    private long idUser;
    private String userName;
    private String password;
    private Date dateOfUserApproval;
    private String rating;
    private UserType USERTYEPE_idUserType;
    private Status STATUS_idStatus;
    private LENDBOOKS LENDBOOKS_idLendBook;

    public UserListModel(long idUser, String userName, String password, Date dateOfUserApproval, String rating, UserType USERTYEPE_idUserType, Status STATUS_idStatus, LENDBOOKS LENDBOOKS_idLendBook) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.dateOfUserApproval = dateOfUserApproval;
        this.rating = rating;
        this.USERTYEPE_idUserType = USERTYEPE_idUserType;
        this.STATUS_idStatus = STATUS_idStatus;
        this.LENDBOOKS_idLendBook = LENDBOOKS_idLendBook;
    }
    public UserListModel()
    {

    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateOfUserApproval() {
        return dateOfUserApproval;
    }

    public void setDateOfUserApproval(Date dateOfUserApproval) {
        this.dateOfUserApproval = dateOfUserApproval;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public UserType getUSERTYEPE_idUserType() {
        return USERTYEPE_idUserType;
    }

    public void setUSERTYEPE_idUserType(UserType USERTYEPE_idUserType) {
        this.USERTYEPE_idUserType = USERTYEPE_idUserType;
    }

    public Status getSTATUS_idStatus() {
        return STATUS_idStatus;
    }

    public void setSTATUS_idStatus(Status STATUS_idStatus) {
        this.STATUS_idStatus = STATUS_idStatus;
    }

    public LENDBOOKS getLENDBOOKS_idLendBook() {
        return LENDBOOKS_idLendBook;
    }

    public void setLENDBOOKS_idLendBook(LENDBOOKS LENDBOOKS_idLendBook) {
        this.LENDBOOKS_idLendBook = LENDBOOKS_idLendBook;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserListModel)) return false;
        UserListModel that = (UserListModel) o;
        return getIdUser() == that.getIdUser() && Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getDateOfUserApproval(), that.getDateOfUserApproval()) && Objects.equals(getRating(), that.getRating()) && Objects.equals(getUSERTYEPE_idUserType(), that.getUSERTYEPE_idUserType()) && Objects.equals(getSTATUS_idStatus(), that.getSTATUS_idStatus()) && Objects.equals(getLENDBOOKS_idLendBook(), that.getLENDBOOKS_idLendBook());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getUserName(), getPassword(), getDateOfUserApproval(), getRating(), getUSERTYEPE_idUserType(), getSTATUS_idStatus(), getLENDBOOKS_idLendBook());
    }

    @Override
    public String toString() {
        return "UserListModel{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateOfUserApproval=" + dateOfUserApproval +
                ", rating='" + rating + '\'' +
                ", USERTYEPE_idUserType=" + USERTYEPE_idUserType +
                ", STATUS_idStatus=" + STATUS_idStatus +
                ", LENDBOOKS_idLendBook=" + LENDBOOKS_idLendBook +
                '}';
    }
}
