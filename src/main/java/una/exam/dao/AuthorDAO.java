
package una.exam.dao;

import una.exam.model.Author;

/**
 *
 * @author Bryan Pérez Delgado
 */


public interface AuthorDAO {

    /**
     *
     * @param name
     * @return
     */
    Author findByName(String name);
}
