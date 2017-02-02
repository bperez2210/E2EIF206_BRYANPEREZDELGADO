
package una.exam.service;

import java.util.List;
import una.exam.dao.AuthorContactDAO;
import una.exam.dao.AuthorDAO;
import una.exam.model.Author;
import una.exam.model.AuthorContact;

/**
 *
 * @author Bryan Pérez Delgado
 */


public class AuthorServiceImpl implements AuthorService{
    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;

    /**
     *
     */
    public AuthorServiceImpl() {
    }

    /**
     *
     * @param authorContactDAO
     */
    public AuthorServiceImpl(AuthorContactDAO authorContactDAO) {
        this.authorContactDAO = authorContactDAO;
    }

    /**
     *
     * @param authorDAO
     */
    public AuthorServiceImpl(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    /**
     *
     * @param authorDAO
     * @param authorContactDAO
     */
    public AuthorServiceImpl(AuthorDAO authorDAO, AuthorContactDAO authorContactDAO) {
        this.authorDAO = authorDAO;
        this.authorContactDAO = authorContactDAO;
    }
    
    /**
     *
     * @return
     */
    @Override
    public boolean deleteAll() {
        return authorContactDAO.deleteAll();
    }

    /**
     *
     * @param authorContact
     * @return
     */
    @Override
    public AuthorContact save(AuthorContact authorContact) {
        return authorContactDAO.save(authorContact);
    }

    /**
     *
     * @return
     */
    @Override
    public List<AuthorContact> findAll() {
        return authorContactDAO.findAll();
    }

    /**
     *
     * @param name
     * @return
     */
    @Override
    public Author findByName(String name) {
        return authorDAO.findByName(name);
    }

    /**
     *
     * @return
     */
    public AuthorDAO getAuthorDAO() {
        return authorDAO;
    }

    /**
     *
     * @param authorDAO
     */
    public void setAuthorDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    /**
     *
     * @return
     */
    public AuthorContactDAO getAuthorContactDAO() {
        return authorContactDAO;
    }

    /**
     *
     * @param authorContactDAO
     */
    public void setAuthorContactDAO(AuthorContactDAO authorContactDAO) {
        this.authorContactDAO = authorContactDAO;
    }
   
}
