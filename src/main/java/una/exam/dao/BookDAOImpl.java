
package una.exam.dao;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import una.exam.model.Book;

/**
 *
 * @author Bryan
 */


public class BookDAOImpl implements BookDAO{
    private final Session session = HibernateUtil.getSessionFactory().openSession();
    
    @Override
    public boolean deleteAll() {
        session.beginTransaction();
        session.createSQLQuery("DELETE FROM book").executeUpdate();
        session.getTransaction().commit();
        return true;
    }

    @Override
    public Book save(Book book) {
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
        return book;
    }

    @Override
    public List<Book> findAll() {
        List<Book> bookList = new ArrayList<>();
        bookList = session.createCriteria(Book.class).list();
        return bookList;   
    }
    
}
