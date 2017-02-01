
package una.exam.dao;

import java.util.List;
import una.exam.model.AuthorContact;

/**
 *
 * @author Bryan
 */


public interface AuthorContactDAO {
    boolean deleteAll();
    AuthorContact save(AuthorContact authorContact);
    List<AuthorContact> findAll();
}
