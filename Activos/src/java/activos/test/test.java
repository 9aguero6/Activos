/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.test;

import activos.dao.EstadosDAO;
import activos.dao.RolesDAO;
import activos.domain.Estados;
import activos.domain.Roles;


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

        RolesDAO roles=new RolesDAO();
        Roles es=new Roles("Doctor");
        roles.save(es);
        System.out.println(roles.findAll().get(1).getNombre());

    }
    
}
