package bg.tu_varna.sit.library.data.access;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Connection {

    private static final Logger log = Logger.getLogger(Connection.class);
    private static SessionFactory sessionFactory;

    static
    {
        try
        {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        }
        catch(Throwable ex)
        {
            log.error("Initial SessionFactory created failed" + ex);
        }
    }
}
