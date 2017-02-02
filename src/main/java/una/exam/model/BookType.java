
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
@Table(name = "booktype", catalog = "progra3_exa2", uniqueConstraints = {
    @UniqueConstraint(columnNames = "idType")})
public class BookType implements Serializable {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "idType")
    private int idType;
    
    @Column(name = "type", unique = false, nullable = false)
    private String type;

    /**
     *
     */
    public BookType() {
    }

    /**
     *
     * @param idType
     * @param type
     */
    public BookType(int idType, String type) {
        this.idType = idType;
        this.type = type;
    }
    
    /**
     *
     * @return
     */
    public int getIdType() {
        return idType;
    }

    /**
     *
     * @param idType
     */
    public void setIdType(int idType) {
        this.idType = idType;
    }

    /**
     *
     * @return
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "BookType{" + "idType=" + idType + ", type=" + type + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + this.idType;
        hash = 89 * hash + Objects.hashCode(this.type);
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
        final BookType other = (BookType) obj;
        if (this.idType != other.idType) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        return true;
    }
    
}
