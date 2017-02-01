
package una.exam.service;

import java.util.List;
import una.exam.model.Book;

/**
 *
 * @author Bryan
 */


public interface BookService {
    boolean deleteAll();
    Book save(Book book);
    List<Book> findAll();
    Float totalPriceAll();
}
