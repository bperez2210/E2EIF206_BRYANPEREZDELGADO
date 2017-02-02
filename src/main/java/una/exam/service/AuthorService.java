
package una.exam.service;

import java.util.List;
import una.exam.model.Author;
import una.exam.model.AuthorContact;

/**
 *
 * @author Bryan Pérez Delgado
 */


public interface AuthorService {

    /**
     *
     * @return
     */
    boolean deleteAll();

    /**
     *
     * @param authorContact
     * @return
     */
    AuthorContact save(AuthorContact authorContact);

    /**
     *
     * @return
     */
    List<AuthorContact> findAll();

    /**
     *
     * @param name
     * @return
     */
    Author findByName(String name);
}
