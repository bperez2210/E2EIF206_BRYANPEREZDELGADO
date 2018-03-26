/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.bl;

import cr.kaytes.modelo.Marca;
import java.util.List;

/**
 *
 * @author bperez2210
 */
public class MarcaBL extends BaseBL implements IBaseBL<Marca,String>{

    public MarcaBL(){
        super();
    }
    @Override
    public Marca save(Marca obj) {
        return (Marca)this.getDAO(obj.getClass().getName()).save(obj);
    }

    @Override
    public void merge(Marca obj) {
        this.getDAO(obj.getClass().getName()).merge(obj);
    }

    @Override
    public void delete(String key) {
        this.getDAO("cr.kaytes.modelo.Marca").delete(key);  
    }

    @Override
    public List<Marca> findAll() {
        return this.getDAO("cr.kaytes.modelo.Marca").findAll();
    }


    @Override
    public List<Marca> findByQuery(String query) {
        return this.getDAO(Marca.class.getName()).findByQuery(query);
    }
    
}
