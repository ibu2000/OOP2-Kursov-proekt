package bg.tu_varna.sit.library.data.entities;

import javax.persistence.*;
import java.util.Date;

@Table(name = "USER")
@Entity
public class USER {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUser",nullable = false)
    private long idUser;

    @Column(name = "userName", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "dateOfUserApproval", nullable = false)
    private Date dateOfUserApproval;


    @Column(name = "rating", nullable = false)
    private String rating;

    @Column(name = "USERTYEPE_idUserType",nullable = false)
    @OneToOne(mappedBy = "idUserType")
    private long USERTYEPE_idUserType;

    @Column(name = "STATUS_idStatus",nullable = false)
    @OneToOne(mappedBy = "idStatus")
    private long STATUS_idStatus;

    @Column(name = "LENDBOOKS_idLendBook",nullable = false)
    @OneToOne(mappedBy = "idLendBook")
    private long LENDBOOKS_idLendBook;


}
