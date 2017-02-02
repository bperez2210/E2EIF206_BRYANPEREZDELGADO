package una.exam.dao;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Bryan Pérez Delgado
 */


public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() throws HibernateException {
        // Create the SessionFactory from hibernate.cfg.xml
        return new AnnotationConfiguration().configure().buildSessionFactory();

    }

    /**
     *
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    /**
     *
     */
    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }
}
