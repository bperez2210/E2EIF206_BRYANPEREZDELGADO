/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.test;

import cr.kaytes.bl.ProductoBL;
import cr.kaytes.modelo.Producto;
import java.util.List;

/**
 *
 * @author bperez2210
 */
public class TestProducto {
    public static void main(String []args){
        saveProducto();
        //mergeProducto();
        //findAll();
        //findByQuery();
    }
    
    public static void saveProducto(){
        Producto emp = new Producto("Bultos");
        ProductoBL bl = new ProductoBL();
        bl.save(emp);
        System.out.println("Producto guardada con exito");
    }
    
    public static void findAll(){
        List<Producto> empresas;
        ProductoBL bl = new ProductoBL();
        empresas = bl.findAll();
        empresas.forEach((aux) -> {System.out.println(aux.toString());});
    }
    
    
    public static void mergeProducto(){
        Producto emp = new Producto("Fajas");
        emp.setPkIdproducto(3);
        ProductoBL bl = new ProductoBL();
        bl.merge(emp);
    }
    
    public static void findByQuery(){
        List<Producto> empresas;
        ProductoBL bl = new ProductoBL();
        empresas = bl.findByQuery("from Producto where PK_IDProducto  > 1");
        empresas.forEach((aux) -> {System.out.println(aux.toString());});
    }
}
