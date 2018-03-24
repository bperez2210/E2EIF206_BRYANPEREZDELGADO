package cr.kaytes.modelo;
// Generated 23/03/2018 10:37:51 AM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Marca generated by hbm2java
 */
@Entity
@Table(name="MARCA"
    ,schema="ADMIN"
    , uniqueConstraints = @UniqueConstraint(columnNames="NOMBRE") 
)
public class Marca  implements java.io.Serializable {


     private int pkIdmarca;
     private String nombre;
     private Set<Articulo> articulos = new HashSet<Articulo>(0);

    public Marca() {
    }

	
    public Marca(int pkIdmarca, String nombre) {
        this.pkIdmarca = pkIdmarca;
        this.nombre = nombre;
    }
    public Marca(int pkIdmarca, String nombre, Set<Articulo> articulos) {
       this.pkIdmarca = pkIdmarca;
       this.nombre = nombre;
       this.articulos = articulos;
    }
   
     @Id 

    
    @Column(name="PK_IDMARCA", unique=true, nullable=false, precision=5, scale=0)
    public int getPkIdmarca() {
        return this.pkIdmarca;
    }
    
    public void setPkIdmarca(int pkIdmarca) {
        this.pkIdmarca = pkIdmarca;
    }

    
    @Column(name="NOMBRE", unique=true, nullable=false, length=25)
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="marca")
    public Set<Articulo> getArticulos() {
        return this.articulos;
    }
    
    public void setArticulos(Set<Articulo> articulos) {
        this.articulos = articulos;
    }




}

