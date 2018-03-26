/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.bl;
import java.util.List;
/**
 *
 * @author bperez2210
 * @param <T>
 * @param <K>
 */
public interface IBaseBL <T,K>{
    public abstract T save(T obj);
    public abstract void merge(T obj);
    public abstract void delete(K key);
    public abstract List<T> findAll();
    public abstract List<T> findByQuery(String query);
}
