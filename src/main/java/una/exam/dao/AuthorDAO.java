
package una.exam.dao;

import una.exam.model.Author;

/**
 *
 * @author Bryan
 */


public interface AuthorDAO {
    Author findByName(String name);
}
