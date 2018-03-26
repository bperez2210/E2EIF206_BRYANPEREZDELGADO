/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.dao;

import cr.kaytes.modelo.Marca;
import cr.kaytes.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author bperez2210
 */
public class MarcaDAO extends HibernateUtil implements IBaseDAO<Marca,Integer>{

    @Override
    public Marca save(Marca obj) {
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
    public void merge(Marca obj) {
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
            Marca e = new Marca();
            e.setPkIdmarca(key);
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
    public List<Marca> findAll() {
        List<Marca> empresas;
        try{
            iniciarOperacion();
            empresas = getSesion().createQuery("FROM Marca order by emp_nombre").list();
        }finally{
            getSesion().close();
        }
        return empresas;
    }


    @Override
    public List<Marca> findByQuery(String query) {
        try{
            List<Marca> empresas;
            iniciarOperacion();
            empresas = (List<Marca>) getSesion().createQuery(query).list();
            return empresas;
        }catch(HibernateException he){
            manejarException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }
}
