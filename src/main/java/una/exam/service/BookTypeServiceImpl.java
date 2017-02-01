
package una.exam.service;

import una.exam.dao.BookTypeDAO;
import una.exam.model.BookType;

/**
 *
 * @author Bryan
 */


public class BookTypeServiceImpl implements BookTypeService{
    private BookTypeDAO bookTypeDAO;

    public BookTypeServiceImpl() {
    }

    public BookTypeServiceImpl(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }
    
    @Override
    public boolean deleteAll() {
        return bookTypeDAO.deleteAll();
    }

    @Override
    public BookType save(BookType bookType) {
        return bookTypeDAO.save(bookType);
    }

    @Override
    public BookType findByName(String name) {
        return bookTypeDAO.findByName(name);
    }
    
}
