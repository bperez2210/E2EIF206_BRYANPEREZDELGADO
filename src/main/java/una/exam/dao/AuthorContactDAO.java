
package una.exam.dao;

import java.util.List;
import una.exam.model.AuthorContact;

/**
 *
 * @author Bryan Pérez Delgado
 */


public interface AuthorContactDAO {

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
}
