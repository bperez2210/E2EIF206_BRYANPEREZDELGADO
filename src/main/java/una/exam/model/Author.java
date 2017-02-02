 
package una.exam.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author Bryan Pérez Delgado
 */

@Entity
@Table(name = "author", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idAuthor")})
public class Author implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idAuthor")
    private int idAuthor;
    @Column(name = "name", unique = false, nullable = false)
    private String name;

    /**
     *
     */
    public Author() {
    }

    /**
     *
     * @param idAuthor
     * @param name
     */
    public Author(int idAuthor, String name) {
        this.idAuthor = idAuthor;
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getIdAuthor() {
        return idAuthor;
    }

    /**
     *
     * @param idAuthor
     */
    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{" + "idAuthor=" + idAuthor + ", name=" + name + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idAuthor;
        hash = 89 * hash + Objects.hashCode(this.name);
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
        final Author other = (Author) obj;
        if (this.idAuthor != other.idAuthor) {
            return false;
        }
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return true;
    }
    
}
