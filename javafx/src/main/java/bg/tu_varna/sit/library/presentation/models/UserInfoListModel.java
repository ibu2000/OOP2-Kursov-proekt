package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.data.entities.USER;

import javax.persistence.Column;
import java.util.Objects;

public class UserInfoListModel {

    private USER User_idUser;
    private String name;
    private String phone;
    private String email;

    public UserInfoListModel() {
    }

    public UserInfoListModel(USER user_idUser, String name, String phone, String email) {
        User_idUser = user_idUser;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public UserInfoListModel(USER user_idUser) {
        User_idUser = user_idUser;
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
        if (!(o instanceof UserInfoListModel)) return false;
        UserInfoListModel that = (UserInfoListModel) o;
        return Objects.equals(getUser_idUser(), that.getUser_idUser()) && Objects.equals(getName(), that.getName()) && Objects.equals(getPhone(), that.getPhone()) && Objects.equals(getEmail(), that.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUser_idUser(), getName(), getPhone(), getEmail());
    }

    @Override
    public String toString() {
        return "UserInfoListModel{" +
                "User_idUser=" + User_idUser +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
