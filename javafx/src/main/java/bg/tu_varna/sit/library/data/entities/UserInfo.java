package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;



@Table(name = "USERINFO")
@Entity
public class UserInfo {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_idUser", referencedColumnName = "idUser")
    private USER User_idUser;

    public UserInfo(USER user_idUser, String name, String phone, String email) {
        User_idUser = user_idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public UserInfo() {
    }

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;


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
