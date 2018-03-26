/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.dao;

import cr.kaytes.modelo.Articulo;
import cr.kaytes.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author bperez2210
 */
public class ArticuloDAO extends HibernateUtil implements IBaseDAO<Articulo,Integer>{

    @Override
    public Articulo save(Articulo obj) {
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
    public void merge(Articulo obj) {
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
            Articulo e = new Articulo();
            e.setPkIdarticulo(key);
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
    public List<Articulo> findAll() {
        List<Articulo> empresas;
        try{
            iniciarOperacion();
            empresas = getSesion().createQuery("FROM Marca").list();
        }finally{
            getSesion().close();
        }
        return empresas;
    }


    @Override
    public List<Articulo> findByQuery(String query) {
        try{
            List<Articulo> empresas;
            iniciarOperacion();
            empresas = (List<Articulo>) getSesion().createQuery(query).list();
            return empresas;
        }catch(HibernateException he){
            manejarException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }
}
