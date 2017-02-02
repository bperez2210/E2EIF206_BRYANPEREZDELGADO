
package una.exam.dao;

import una.exam.model.BookType;

/**
 *
 * @author Bryan Pérez Delgado
 */


public interface BookTypeDAO {

    /**
     *
     * @return
     */
    boolean deleteAll();

    /**
     *
     * @param bookType
     * @return
     */
    BookType save(BookType bookType);

    /**
     *
     * @param name
     * @return
     */
    BookType findByName(String name);
}
