package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;



@Table(name = "USERINFO")
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "idUser", nullable = false)
    @OneToOne(mappedBy = "idUser")
    private long idUser;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "email", nullable = false)
    private String email;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long id) {
        this.idUser = id;
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
                "id: " + idUser +
                ", Name: '" + name + '\'' +
                ", phone: " + phone +
                ", email: " + email +
                '}';
    }
}
