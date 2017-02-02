 
package una.exam.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.Session;
import una.exam.model.AuthorContact;

/**
 *
 * @author Bryan
 */


public class AuthorContactDAOImpl implements AuthorContactDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public boolean deleteAll() {
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM authorcontact").executeUpdate();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public AuthorContact save(AuthorContact authorContact) {
        session.beginTransaction();
        session.save(authorContact);
        session.getTransaction().commit();
        return authorContact;
    }

    @Override
    public List<AuthorContact> findAll() {
        List<AuthorContact> authorContactList = new ArrayList<>();
        authorContactList = session.createCriteria(AuthorContact.class).list();
        return authorContactList; 
    }
    
}
