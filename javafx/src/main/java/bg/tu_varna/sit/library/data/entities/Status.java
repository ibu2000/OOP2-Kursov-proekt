package bg.tu_varna.sit.library.data.entities;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;


@Table(name = "STATUS")
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStatus", nullable = false)
    private long idStatus;


    @Column(name = "status",nullable = false)
    private String status;

    public Status(long idStatus, String status) {
        this.idStatus = idStatus;
        this.status = status;
    }

    public Status() {
    }

    public long getIdStatus() {
        return idStatus;
    }

    public void setIdStatus(long idStatus) {
        this.idStatus = idStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Status)) return false;
        Status status1 = (Status) o;
        return getIdStatus() == status1.getIdStatus() && Objects.equals(getStatus(), status1.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdStatus(), getStatus());
    }

    @Override
    public String toString() {
        return "Status{" +
                "idStatus: " + idStatus +
                ", status: '" + status + '\'' +
                '}';
    }
}
