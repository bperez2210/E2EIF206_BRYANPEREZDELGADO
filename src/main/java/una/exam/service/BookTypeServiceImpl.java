
package una.exam.service;

import una.exam.dao.BookTypeDAO;
import una.exam.model.BookType;

/**
 *
 * @author Bryan Pérez Delgado
 */


public class BookTypeServiceImpl implements BookTypeService{
    private BookTypeDAO bookTypeDAO;

    /**
     *
     */
    public BookTypeServiceImpl() {
    }

    /**
     *
     * @param bookTypeDAO
     */
    public BookTypeServiceImpl(BookTypeDAO bookTypeDAO) {
        this.bookTypeDAO = bookTypeDAO;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        return bookTypeDAO.deleteAll();
    }

    /**
     *
     * @param bookType
     * @return
     */
    @Override
    public BookType save(BookType bookType) {
        return bookTypeDAO.save(bookType);
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public BookType findByName(String name) {
        return bookTypeDAO.findByName(name);
    }
    
}
