
package una.exam.webservice;


import una.exam.dao.AuthorContactDAO;
import una.exam.dao.AuthorDAO;
import una.exam.model.Author;
import una.exam.model.AuthorContact;
import una.exam.service.AuthorService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import una.exam.dao.AuthorContactDAOImpl;
import una.exam.dao.AuthorDAOImpl;
import una.exam.service.AuthorServiceImpl;
/**
 *
 * @author Bryan Pérez Delgado
 */

@Path("authors")
public class AuthorWebservice {
    private AuthorDAO authorDAO;
    private AuthorContactDAO authorContactDAO;
    private AuthorService authorService;
    
    @Context
    private UriInfo context;

    /**
     *
     */
    public AuthorWebservice() {
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<AuthorContact> getAllAuthors(){
        List<AuthorContact> authorsList = null;
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorContactDAO);
        authorsList = authorService.findAll();
        return authorsList;
    }
    
    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Author getAuthorByName(@PathParam("name")String name){
        Author author = null;
        authorDAO = new AuthorDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO);
        author = authorService.findByName(name);
        return author;
    }
    
    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll(){
        boolean result;
        authorDAO = new AuthorDAOImpl();
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorDAO,authorContactDAO);
        result = authorService.deleteAll();
        return result;
    }
    
    /**
     *
     * @param authorContact
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public AuthorContact createAuthor(AuthorContact authorContact){
        authorContactDAO = new AuthorContactDAOImpl();
        authorService = new AuthorServiceImpl(authorContactDAO);
        authorContact = authorService.save(authorContact);
        return authorContact;
    }
}
