
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
        List<Author> authorList = new ArrayList<>();
        authorList = session.createCriteria(Author.class).list();
        for(Author author : authorList){
            if(author.getName().equals(name)){
                return author;
            }
        }
        return null;
    }
    
}
