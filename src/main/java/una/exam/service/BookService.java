
package una.exam.service;

import java.util.List;
import una.exam.model.Book;

/**
 *
 * @author Bryan Pérez Delgado
 */


public interface BookService {

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

    /**
     *
     * @return
     */
    Float totalPriceAll();
}
