
package una.exam.dao;

import una.exam.model.BookType;

/**
 *
 * @author Bryan
 */


public interface BookTypeDAO {
    boolean deleteAll();
    BookType save(BookType bookType);
    BookType findByName(String name);
}
