/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.test;

import cr.kaytes.bl.ArticuloBL;
import cr.kaytes.modelo.Articulo;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author bperez2210
 */
public class TestArticulo {
    public static void main(String []args){
        saveArticulo();
        //mergeArticulo();
        //findAll();
        //findByQuery();
    }
    
    public static void saveArticulo(){
        Articulo emp = new Articulo(1,1,6549,"Amarillo",15000,"BODEGA");
        ArticuloBL bl = new ArticuloBL();
        bl.save(emp);
        System.out.println("Articulo guardada con exito");
    }
    
    public static void findAll(){
        List<Articulo> empresas;
        ArticuloBL bl = new ArticuloBL();
        empresas = bl.findAll();
        empresas.forEach((aux) -> {System.out.println(aux.toString());});
    }
    
    
    public static void mergeArticulo(){
        Articulo emp = new Articulo(1,2,6549,"Verde",15000,"CAMBIO");
        emp.setPkIdarticulo(1);
        ArticuloBL bl = new ArticuloBL();
        bl.merge(emp);
    }
    
    public static void findByQuery(){
        List<Articulo> empresas;
        ArticuloBL bl = new ArticuloBL();
        empresas = bl.findByQuery("from Articulo where PK_IDArticulo  > 1");
        empresas.forEach((aux) -> {System.out.println(aux.toString());});
    }
}
