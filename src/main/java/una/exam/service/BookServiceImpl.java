
package una.exam.service;

import java.util.List;
import una.exam.dao.BookDAO;
import una.exam.model.Book;

/**
 *
 * @author Bryan Pérez Delgado
 */


public class BookServiceImpl implements BookService{
    private BookDAO bookDAO;

    /**
     *
     */
    public BookServiceImpl() {
    }

    /**
     *
     * @param bookDAO
     */
    public BookServiceImpl(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    /**
     *
     * @return
     */
    public BookDAO getBookDAO() {
        return bookDAO;
    }

    /**
     *
     * @param bookDAO
     */
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
   
    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        return bookDAO.deleteAll();
    }

    /**
     *
     * @param book
     * @return
     */
    @Override
    public Book save(Book book) {
        return bookDAO.save(book);
    }

    /**
     *
     * @return
     */
    @Override
    public List<Book> findAll() {
        return bookDAO.findAll();
    }

    /**
     *
     * @return
     */
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
