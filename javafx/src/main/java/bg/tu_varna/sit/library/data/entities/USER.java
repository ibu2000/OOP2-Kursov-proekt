package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Table(name = "USER")
@Entity
public class USER {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser",nullable = false)
    private long idUser;

    @OneToOne(mappedBy = "byUSER")
    private UserInfo UserInfo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="foreignUSERTYPE_idUserType",referencedColumnName = "USERTYPE_idUserType")
    private UserType UserType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="foreignidForm",referencedColumnName = "foreignidForm")
    private FORM FORM;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dateOfUserApproval", nullable = false)
    private Date dateOfUserApproval;


    @Column(name = "rating", nullable = false)
    private String rating;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERTYEPE_idUserType",referencedColumnName = "idUserType",nullable = false)
    private UserType USERTYEPE_idUserType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATUS_idStatus",referencedColumnName = "idStatus",nullable = false)
    private Status STATUS_idStatus;


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

    @Override
    public String toString() {
        return "USER{" +
                "idUser=" + idUser +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", dateOfUserApproval=" + dateOfUserApproval +
                ", rating='" + rating + '\'' +
                ", USERTYEPE_idUserType=" + USERTYEPE_idUserType +
                ", STATUS_idStatus=" + STATUS_idStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        USER user = (USER) o;
        return Objects.equals(userName, user.userName) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userName, password);
    }
}

