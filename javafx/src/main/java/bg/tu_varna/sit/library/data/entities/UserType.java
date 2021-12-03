package bg.tu_varna.sit.library.data.entities;


import javax.persistence.*;

@Table(name = "USERTYPE")
@Entity
public class UserType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUserType", nullable = false)
    private long idUserType;

    @Column(name = "userType",nullable = false)
    private String userType;

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
        return "UserType{" +
                "idUserType: " + idUserType +
                ", userType: '" + userType + '\'' +
                '}';
    }
}