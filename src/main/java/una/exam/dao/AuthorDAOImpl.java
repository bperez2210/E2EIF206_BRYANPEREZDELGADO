
package una.exam.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.exam.model.Author;


/**
 *
 * @author Bryan
 */


public class AuthorDAOImpl implements AuthorDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public Author findByName(String name) {
        Author author = null;
        Query query =  session.createQuery("from author where name = :name ");
        query.setParameter("name", name);
        if (query.list().size() > 0) {
            author = (Author) query.list().get(0);
        }
        return author;
    }
    
}
