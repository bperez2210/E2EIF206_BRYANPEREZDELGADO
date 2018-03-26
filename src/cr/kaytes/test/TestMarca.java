/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.kaytes.test;

import cr.kaytes.bl.MarcaBL;
import cr.kaytes.modelo.Marca;
import java.util.List;

/**
 *
 * @author bperez2210
 */
public class TestMarca {
    
    public static void main(String []args){
        saveMarca();
        //mergeMarca();
        //findAll();
        //findBySectorMarca();
        //findByQuery();
    }
    
    public static void saveMarca(){
        Marca emp = new Marca("Adidas");
        MarcaBL bl = new MarcaBL();
        bl.save(emp);
        System.out.println("Marca guardada con exito");
    }
    
    public static void findAll(){
        List<Marca> empresas;
        MarcaBL bl = new MarcaBL();
        empresas = bl.findAll();
        empresas.forEach((aux) -> {System.out.println(aux.toString());});
    }
    
    
    public static void mergeMarca(){
        Marca emp = new Marca("Converse");
        emp.setPkIdmarca(3);
        MarcaBL bl = new MarcaBL();
        bl.merge(emp);
    }
    
    public static void findByQuery(){
        List<Marca> empresas;
        MarcaBL bl = new MarcaBL();
        empresas = bl.findByQuery("from Marca where PK_IDMarca  > 1");
        empresas.forEach((aux) -> {System.out.println(aux.toString());});
    }

}
