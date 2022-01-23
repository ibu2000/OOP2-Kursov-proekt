package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.data.entities.LENDBOOKS;
import bg.tu_varna.sit.library.data.entities.Status;
import bg.tu_varna.sit.library.data.entities.UserType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

public class UserListModel {

    private long idUser;
    private String userName;
    private String password;
    private LocalDate dateOfUserApproval;
    private String rating;
    private UserType USERTYEPE_idUserType;
    private Status STATUS_idStatus;


    public UserListModel(long idUser, String userName, String password, LocalDate dateOfUserApproval, String rating, UserType USERTYEPE_idUserType, Status STATUS_idStatus) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.dateOfUserApproval = dateOfUserApproval;
        this.rating = rating;
        this.USERTYEPE_idUserType = USERTYEPE_idUserType;
        this.STATUS_idStatus = STATUS_idStatus;
    }

    public UserListModel()
    {

    }

    public UserListModel(String userName, String password, LocalDate dateOfUserApproval, String rating, UserType USERTYEPE_idUserType, Status STATUS_idStatus) {
        this.userName = userName;
        this.password = password;
        this.dateOfUserApproval = dateOfUserApproval;
        this.rating = rating;
        this.USERTYEPE_idUserType = USERTYEPE_idUserType;
        this.STATUS_idStatus = STATUS_idStatus;
    }

    public UserListModel(String text, String text1) {
        this.userName = text;
        this.password = text1;
    }

    public UserListModel(String userName) {
        this.userName = userName;
    }

    public UserListModel(String userName, String password, UserType USERTYEPE_idUserType) {
        this.userName = userName;
        this.password = password;
        this.USERTYEPE_idUserType = USERTYEPE_idUserType;
    }

    public UserListModel(long idUser, Status STATUS_idStatus) {
        this.idUser = idUser;
        this.STATUS_idStatus = STATUS_idStatus;
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

    public LocalDate getDateOfUserApproval() {
        return dateOfUserApproval;
    }

    public void setDateOfUserApproval(LocalDate dateOfUserApproval) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserListModel)) return false;
        UserListModel that = (UserListModel) o;
        return getIdUser() == that.getIdUser() && Objects.equals(getUserName(), that.getUserName()) && Objects.equals(getPassword(), that.getPassword()) && Objects.equals(getDateOfUserApproval(), that.getDateOfUserApproval()) && Objects.equals(getRating(), that.getRating()) && Objects.equals(getUSERTYEPE_idUserType(), that.getUSERTYEPE_idUserType()) && Objects.equals(getSTATUS_idStatus(), that.getSTATUS_idStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getUserName(), getPassword(), getDateOfUserApproval(), getRating(), getUSERTYEPE_idUserType(), getSTATUS_idStatus());
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
                '}';
    }
}
