package bg.tu_varna.sit.library.data.entities;
import javax.persistence.*;
import java.io.Serializable;

@Table(name = "tasks")
@Entity
public class Task implements Serializable
{
    private static final long serialVersionUID = 1L;


    @Id
    @GeneratedValue
}
