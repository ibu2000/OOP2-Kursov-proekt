package bg.tu_varna.sit.library.data.entities;
import javax.persistence.*;



@Table(name = "STATUS")
@Entity
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idStatus", nullable = false)
    private long idStatus;

    @Column(name = "status",nullable = false)
    private String status;

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
    public String toString() {
        return "Status{" +
                "idStatus: " + idStatus +
                ", status: '" + status + '\'' +
                '}';
    }
}
