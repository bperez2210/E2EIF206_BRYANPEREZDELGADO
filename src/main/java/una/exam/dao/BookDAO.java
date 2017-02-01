
package una.exam.dao;

import java.util.List;
import una.exam.model.Book;

/**
 *
 * @author Bryan
 */


public interface BookDAO {
    boolean deleteAll();
    Book save(Book book);
    List<Book> findAll();
}
