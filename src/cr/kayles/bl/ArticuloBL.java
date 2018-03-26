/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kayles.bl;

import cr.kaytes.modelo.Articulo;
import java.util.List;

/**
 *
 * @author bperez2210
 */
public class ArticuloBL extends BaseBL implements IBaseBL<Articulo,String>{

    public ArticuloBL(){
        super();
    }
    @Override
    public Articulo save(Articulo obj) {
        return (Articulo)this.getDAO(obj.getClass().getName()).save(obj);
    }

    @Override
    public void merge(Articulo obj) {
        this.getDAO(obj.getClass().getName()).merge(obj);
    }

    @Override
    public void delete(String key) {
        this.getDAO("cr.or.uccaep.domain.Articulo").delete(key);  
    }

    @Override
    public List<Articulo> findAll() {
        return this.getDAO("cr.or.uccaep.domain.Articulo").findAll();
    }


    @Override
    public List<Articulo> findByQuery(String query) {
        return this.getDAO(Articulo.class.getName()).findByQuery(query);
    }

   
}