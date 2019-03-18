/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.test;

import activos.dao.EstadosDAO;
import activos.domain.Estados;

/**
 *
 * @author USUARIO
 */
public class test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        EstadosDAO estados=new EstadosDAO();
        Estados es=new Estados("ACTIVO");
        estados.save(es);
        System.out.println(estados.findAll().get(0).getNombre());
    }
    
}
