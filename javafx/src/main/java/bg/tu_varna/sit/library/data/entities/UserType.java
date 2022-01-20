package bg.tu_varna.sit.library.data.entities;


import javax.persistence.*;
import java.util.Set;

@Table(name = "USERTYPE")
@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUserType", nullable = false)
    private long idUserType;


    @JoinColumn(name = "userType",referencedColumnName = "userType",nullable = false)
    private String userType;

    public UserType(long idUserType, String userType) {
        this.idUserType = idUserType;
        this.userType = userType;
    }

    public UserType() {
    }

    public long getIdUserType() {
        return idUserType;
    }

    public void setIdUserType(long idUserType) {
        this.idUserType = idUserType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String toString() {
        return userType + " ";
    }
}
