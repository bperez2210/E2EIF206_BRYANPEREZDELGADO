
package una.exam.dao;

import java.util.List;
import una.exam.model.Book;

/**
 *
 * @author Bryan Pérez Delgado
 */


public interface BookDAO {

    /**
     *
     * @return
     */
    boolean deleteAll();

    /**
     *
     * @param book
     * @return
     */
    Book save(Book book);

    /**
     *
     * @return
     */
    List<Book> findAll();
}
