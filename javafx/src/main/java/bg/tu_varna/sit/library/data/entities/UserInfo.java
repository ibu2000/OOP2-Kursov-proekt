package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;


@Table(name = "USERINFO")
@Entity
public class UserInfo implements Serializable {
    @Id
    @OneToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    private USER User_idUser;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    public UserInfo(USER user_idUser, String name, String phone, String email) {
        User_idUser = user_idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public UserInfo() {
    }

    public USER getUser_idUser() {
        return User_idUser;
    }

    public void setUser_idUser(USER user_idUser) {
        User_idUser = user_idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserInfo)) return false;
        UserInfo userInfo = (UserInfo) o;
        return Objects.equals(getUser_idUser(), userInfo.getUser_idUser()) && Objects.equals(getName(), userInfo.getName()) && Objects.equals(getPhone(), userInfo.getPhone()) && Objects.equals(getEmail(), userInfo.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_idUser(), getName(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "User_idUser=" + User_idUser +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
