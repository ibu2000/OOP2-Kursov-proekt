package bg.tu_varna.sit.library.presentation.models;

import bg.tu_varna.sit.library.data.entities.USER;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class FormModel {

    private long idForm;
    private LocalDate submitionDate;
    private USER USER_idUser;
    private String content;
    private String status;

    public FormModel() {
    }

    public FormModel(long idForm, LocalDate submitionDate, USER USER_idUser, String content, String status) {
        this.idForm = idForm;
        this.submitionDate = submitionDate;
        this.USER_idUser = USER_idUser;
        this.content = content;
        this.status = status;
    }

    public FormModel(LocalDate submitionDate, USER USER_idUser, String content, String status) {
        this.submitionDate = submitionDate;
        this.USER_idUser = USER_idUser;
        this.content = content;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getIdForm() {
        return idForm;
    }

    public void setIdForm(long idForm) {
        this.idForm = idForm;
    }

    public LocalDate getSubmitionDate() {
        return submitionDate;
    }

    public void setSubmitionDate(LocalDate submitionDate) {
        this.submitionDate = submitionDate;
    }

    public USER getUSER_idUser() {
        return USER_idUser;
    }

    public void setUSER_idUser(USER USER_idUser) {
        this.USER_idUser = USER_idUser;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FormModel)) return false;
        FormModel formModel = (FormModel) o;
        return getIdForm() == formModel.getIdForm() && Objects.equals(getSubmitionDate(), formModel.getSubmitionDate()) && Objects.equals(getUSER_idUser(), formModel.getUSER_idUser()) && Objects.equals(getContent(), formModel.getContent()) && Objects.equals(getStatus(), formModel.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdForm(), getSubmitionDate(), getUSER_idUser(), getContent(), getStatus());
    }


    @Override
    public String toString() {
        return "FormModel{" +
                "idForm=" + idForm +
                ", submitionDate=" + submitionDate +
                ", USER_idUser=" + USER_idUser +
                ", content='" + content + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
