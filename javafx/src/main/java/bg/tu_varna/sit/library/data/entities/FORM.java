package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "FORM")
@Entity
public class FORM {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idForm", nullable = false)
    private long idForm;

    @Column(name = "submitionDate", nullable = false)
    private Date submitionDate;
    

}