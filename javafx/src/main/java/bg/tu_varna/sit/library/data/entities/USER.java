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


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "USERTYEPE_idUserType",referencedColumnName = "idUserType",nullable = false)
    private long USERTYEPE_idUserType;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "STATUS_idStatus",referencedColumnName = "idStatus",nullable = false)
    private long STATUS_idStatus;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "LENDBOOKS_idLendBook",referencedColumnName = "idLendBook",nullable = false)
    private long LENDBOOKS_idLendBook;


}
