
package una.exam.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
/**
 *
 * @author Bryan
 */

@Entity
@Table(name = "book", catalog = "progra3_exam2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idBook")})
public class Book implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idBook")
    private int idBook;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idAuthor", nullable = false)
    private Author idAuthor;
    
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idType", nullable = false)
    private BookType idType;
    
    @Column(name = "name", unique = false, nullable = false)
    private String name;
    
    @Column(name = "dateRelease")
    @Temporal(TemporalType.DATE)
    private Date dateRelease;
    
    @Column(name = "price", nullable = false)
    private float price;

    public Book() {
    }

    public Book(int idBook, Author idAuthor, BookType idType, String name, Date dateRelease, float price) {
        this.idBook = idBook;
        this.idAuthor = idAuthor;
        this.idType = idType;
        this.name = name;
        this.dateRelease = dateRelease;
        this.price = price;
    }

    public int getIdBook() {
        return idBook;
    }

    public void setIdBook(int idBook) {
        this.idBook = idBook;
    }

    public Author getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Author idAuthor) {
        this.idAuthor = idAuthor;
    }

    public BookType getIdType() {
        return idType;
    }

    public void setIdType(BookType idType) {
        this.idType = idType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateRelease() {
        return dateRelease;
    }

    public void setDateRelease(Date dateRelease) {
        this.dateRelease = dateRelease;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" + "idBook=" + idBook + ", idAuthor=" + idAuthor + ", idType=" + idType + ", name=" + name + ", dateRelease=" + dateRelease + ", price=" + price + '}';
    }
    
    
    
        
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idBook;
        hash = 89 * hash + Objects.hashCode(this.idAuthor);
        hash = 89 * hash + Objects.hashCode(this.idBook);
        hash = 89 * hash + Objects.hashCode(this.idType);
        hash = 89 * hash + Objects.hashCode(this.dateRelease);
        hash = 89 * hash + Objects.hashCode(this.name);
        hash = 89 * hash + Objects.hashCode(this.price);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Book other = (Book)obj;
        if (this.idBook != other.idBook) {
            return false;
        }
        if (!Objects.equals(this.idAuthor, other.idAuthor)) {
            return false;
        }
        if (!Objects.equals(this.idType, other.idType)) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.dateRelease, other.dateRelease)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
            return false;
        }
        return true;
    }
}
