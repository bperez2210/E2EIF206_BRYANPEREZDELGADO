/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kayles.bl;
import cr.kaytes.dao.*;
import java.util.LinkedHashMap;
/**
 *
 * @author bperez2210
 */
public class BaseBL {
    private final LinkedHashMap<String, IBaseDAO> daos;
    
    public BaseBL(){
        daos = new LinkedHashMap();
        daos.put("cr.kaytes.modelo.Marca",new MarcaDAO());
        daos.put("cr.kaytes.modelo.Producto",new ProductoDAO());
        daos.put("cr.kaytes.modelo.Articulo",new ArticuloDAO());
    }
    
    public IBaseDAO getDAO(String className){
        return daos.get(className);
    }
}
