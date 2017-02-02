
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
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.GenericType;
import una.exam.dao.BookDAO;
import una.exam.dao.BookDAOImpl;
import una.exam.model.Book;
import una.exam.service.BookService;
import una.exam.service.BookServiceImpl;
/**
 *
 * @author Bryan Pérez Delgado
 */

@Path("books")
public class BookWebservice {
    private BookDAO bookDAO;
    private BookService bookService;
    
    @Context
    private UriInfo context;

    /**
     *
     */
    public BookWebservice() {
    }
    
    /**
     *
     * @return
     */
    @DELETE
    @Path("/")
    public boolean deleteAll(){
        boolean result;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);
        result = bookService.deleteAll();
        return result;
    }
    
    /**
     *
     * @param book
     * @return
     */
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Book createBook(Book book){
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);
        book = bookService.save(book);
        return book;  
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("/")
    public List<Book> getAllBooks(){
        List<Book> booksList = null;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);
        booksList = bookService.findAll();
        return booksList;
    }
    
    /**
     *
     * @return
     */
    @GET
    @Path("/totalprice")
    public float getTotalPrice(){
        Float total;
        bookDAO = new BookDAOImpl();
        bookService = new BookServiceImpl(bookDAO);
        total = bookService.totalPriceAll();
        System.out.println(total);
        return total;
        
    }
    
    
}
