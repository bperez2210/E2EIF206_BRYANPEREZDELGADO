/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kayles.bl;

import cr.kaytes.modelo.Producto;
import java.util.List;

/**
 *
 * @author bperez2210
 */
public class ProductoBL extends BaseBL implements IBaseBL<Producto,String>{

    public ProductoBL(){
        super();
    }
    @Override
    public Producto save(Producto obj) {
        return (Producto)this.getDAO(obj.getClass().getName()).save(obj);
    }

    @Override
    public void merge(Producto obj) {
        this.getDAO(obj.getClass().getName()).merge(obj);
    }

    @Override
    public void delete(String key) {
        this.getDAO("cr.or.uccaep.domain.Producto").delete(key);  
    }

    @Override
    public List<Producto> findAll() {
        return this.getDAO("cr.or.uccaep.domain.Producto").findAll();
    }


    @Override
    public List<Producto> findByQuery(String query) {
        return this.getDAO(Producto.class.getName()).findByQuery(query);
    }
}
