/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.dao;

import cr.kaytes.modelo.Producto;
import cr.kaytes.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author bperez2210
 */
public class ProductoDAO extends HibernateUtil implements IBaseDAO<Producto,Integer>{

    @Override
    public Producto save(Producto obj) {
        try{
            iniciarOperacion();
            getSesion().save(obj);
            getTransac().commit();
            return obj;
        }catch(HibernateException he){
            manejarException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }

    @Override
    public void merge(Producto obj) {
        try{
            iniciarOperacion();
            getSesion().merge(obj);
            getTransac().commit();
        }catch(HibernateException he){
            manejarException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }


    @Override
    public void delete(Integer key) {
        try{
            Producto e = new Producto();
            e.setPkIdproducto(key);
            iniciarOperacion();
            getSesion().delete(e);
            getTransac().commit();
        }catch(HibernateException he){
            manejarException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }

    @Override
    public List<Producto> findAll() {
        List<Producto> empresas;
        try{
            iniciarOperacion();
            empresas = getSesion().createQuery("FROM Producto order by emp_nombre").list();
        }finally{
            getSesion().close();
        }
        return empresas;
    }


    @Override
    public List<Producto> findByQuery(String query) {
        try{
            List<Producto> empresas;
            iniciarOperacion();
            empresas = (List<Producto>) getSesion().createQuery(query).list();
            return empresas;
        }catch(HibernateException he){
            manejarException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }


    
    
    
}
