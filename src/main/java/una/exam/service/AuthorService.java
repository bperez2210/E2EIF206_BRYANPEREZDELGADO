
package una.exam.service;

import java.util.List;
import una.exam.model.Author;
import una.exam.model.AuthorContact;

/**
 *
 * @author Bryan
 */


public interface AuthorService {
    boolean deleteAll();
    AuthorContact save(AuthorContact authorContact);
    List<AuthorContact> findAll();
    Author findByName(String name);
}
