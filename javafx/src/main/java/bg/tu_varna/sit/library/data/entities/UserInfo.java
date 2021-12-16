package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;



@Table(name = "USERINFO")
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser", nullable = false)
    private int idUser;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USER_idUser", referencedColumnName = "idUser")
    private USER User_idUser;
  /*
    @JoinColumn(name = "idUser",referencedColumnName = "idUser")
    private USER byUSER;*/



    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

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
    public String toString() {
        return "UserInfo{" +
                "User_idUser=" + User_idUser +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
