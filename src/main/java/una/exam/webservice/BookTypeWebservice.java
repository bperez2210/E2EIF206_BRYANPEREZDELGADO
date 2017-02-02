
package una.exam.webservice;

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
import una.exam.dao.BookTypeDAO;
import una.exam.dao.BookTypeDAOImpl;
import una.exam.model.BookType;
import una.exam.service.BookTypeService;
import una.exam.service.BookTypeServiceImpl;
/**
 *
 * @bookType Bryan Pérez Delgado
 */

@Path("booktypes")
public class BookTypeWebservice {
    private BookTypeDAO bookTypeDAO;
    private BookTypeService bookTypeService;
    
    @Context
    private UriInfo context;

    /**
     *
     */
    public BookTypeWebservice() {
    }
    
    /**
     *
     * @param name
     * @return
     */
    @GET
    @Path("/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public BookType getByName(@PathParam("name") String name){
        BookType bookType = null;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        bookType = bookTypeService.findByName(name);
        return bookType;
    }
    
    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll(){
        boolean result;
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        result = bookTypeService.deleteAll();
        return result;
    }
    
    /**
     *
     * @param bookType
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public BookType createBookType(BookType bookType){
        bookTypeDAO = new BookTypeDAOImpl();
        bookTypeService = new BookTypeServiceImpl(bookTypeDAO);
        bookType = bookTypeService.save(bookType);
        return bookType;
    }
            
}
