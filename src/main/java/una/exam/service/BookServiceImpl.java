
package una.exam.service;

import java.util.List;
import una.exam.dao.BookDAO;
import una.exam.model.Book;

/**
 *
 * @author Bryan
 */


public class BookServiceImpl implements BookService{
    private BookDAO bookDAO;

    public BookServiceImpl() {
    }

    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public BookDAO getBookDAO() {
        return bookDAO;
    }

    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
   
    
    @Override
    public boolean deleteAll() {
        return bookDAO.deleteAll();
    }

    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    @Override
    public Float totalPriceAll() {
        List<Book> books = findAll();
        float total = 0;
        for(Book book : books){
            total = total + book.getPrice();
        }
        return total;
    }
    
}
