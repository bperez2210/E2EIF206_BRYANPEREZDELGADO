
package una.exam.service;

import una.exam.model.BookType;

/**
 *
 * @author Bryan
 */


public interface BookTypeService {
    boolean deleteAll();
    BookType save(BookType bookType);
    BookType findByName(String name);
}
