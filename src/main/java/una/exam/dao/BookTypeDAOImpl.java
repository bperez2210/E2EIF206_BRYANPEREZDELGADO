
package una.exam.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.exam.model.BookType;

/**
 *
 * @author Bryan
 */


public class BookTypeDAOImpl implements BookTypeDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public boolean deleteAll() {
        List<BookType> bookTypeList = new ArrayList<>();
        bookTypeList = session.createCriteria(BookType.class).list();
        bookTypeList.clear();
        return (bookTypeList.isEmpty());
    }

    @Override
    public BookType save(BookType bookType) {
        session.beginTransaction();
        session.save(bookType);
        session.getTransaction().commit();
        return bookType; 
    }

    @Override
    public BookType findByName(String name) {
        BookType bookType = null;
        Query query = session.createQuery("from booktype where name = :name ");
        query.setParameter("name", name);
        if (query.list().size() > 0) {
            bookType = (BookType) query.list().get(0);
        }
        return bookType;
    }
    
}
