package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

@Table(name = "USER")
@Entity
public class USER {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser",nullable = false)
    private long idUser;


    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dateOfUserApproval", nullable = false)
    private LocalDate dateOfUserApproval;


    @Column(name = "rating", nullable = false)
    private String rating;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATUS_idStatus",referencedColumnName = "idStatus",nullable = false)
    private Status STATUS_idStatus;

    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERTYPE_idUserType",referencedColumnName = "idUserType",nullable = false)
    private UserType USERTYPE_idUserType;

    public USER(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public USER() {
    }

    public USER(long idUser, String userName, String password,LocalDate dateOfUserApproval, String rating, Status STATUS_idStatus, UserType USERTYPE_idUserType) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.dateOfUserApproval = dateOfUserApproval;
        this.rating = rating;
        this.STATUS_idStatus = STATUS_idStatus;
        this.USERTYPE_idUserType = USERTYPE_idUserType;
    }

    public USER(long idUser, Status STATUS_idStatus) {
        this.idUser = idUser;
        this.STATUS_idStatus = STATUS_idStatus;
    }

    public USER(String userName) {
        this.userName = userName;
    }

    public USER(long idUser, String userName) {
        this.idUser = idUser;
        this.userName = userName;
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

    public void setUSERTYPE_idUserType(UserType USERTYPE_idUserType) {
        this.USERTYPE_idUserType = USERTYPE_idUserType;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public UserType getUSERTYPE_idUserType() {
        return USERTYPE_idUserType;
    }

    public void setUSERTYEPE_idUserType(UserType USERTYPE_idUserType) {
        this.USERTYPE_idUserType = USERTYPE_idUserType;
    }

    public Status getSTATUS_idStatus() {
        return STATUS_idStatus;
    }

    public void setSTATUS_idStatus(Status STATUS_idStatus) {
        this.STATUS_idStatus = STATUS_idStatus;
    }

    @Override
    public String toString() {
        return "USER{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateOfUserApproval=" + dateOfUserApproval +
                ", rating='" + rating + '\'' +
                ", STATUS_idStatus=" + STATUS_idStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof USER)) return false;
        USER user = (USER) o;
        return getIdUser() == user.getIdUser() && Objects.equals(getUserName(), user.getUserName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getDateOfUserApproval(), user.getDateOfUserApproval()) && Objects.equals(getRating(), user.getRating()) && Objects.equals(getSTATUS_idStatus(), user.getSTATUS_idStatus()) && Objects.equals(getUSERTYPE_idUserType(), user.getUSERTYPE_idUserType());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdUser(), getUserName(), getPassword(), getDateOfUserApproval(), getRating(), getSTATUS_idStatus(), getUSERTYPE_idUserType());
    }
}

