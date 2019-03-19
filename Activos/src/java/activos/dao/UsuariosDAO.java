/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Usuarios;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Adriana
 */
public class UsuariosDAO extends HibernateUtil implements IBaseDao <Usuarios, Integer>  {

    @Override
    public void save(Usuarios o) {
       try{
            iniciaOperacion();
            getSesion().save(o);
            getTrans().commit();
        }catch (HibernateException he){
        manejaException(he);
        throw he;
        }finally{
            getSesion().close();
        }
    }

    @Override
    public Usuarios merge(Usuarios o) {
        try{
             iniciaOperacion();
             o=(Usuarios) getSesion().merge(o);
             getTrans().commit();
         }catch (HibernateException he){
             manejaException(he);
             throw he;
         }finally{
             getSesion().close();
         }
         return o;
    }

    @Override
    public void delete(Usuarios o) {
       try{
            iniciaOperacion();
            getSesion().delete(o);
            getTrans().commit();
        }catch (HibernateException he){
            manejaException(he);
            throw he;
        }finally {
            getSesion().close();
        }
    }

    @Override
    public Usuarios findById(Integer o) {
        Usuarios usuarios = null;
        try{
            iniciaOperacion();
            usuarios = (Usuarios) getSesion().get(Usuarios.class,o);
        }finally{
            getSesion();
        }
        return usuarios;
    }

    @Override
    public List<Usuarios> findAll() {
         List<Usuarios> listaUsuarios;
        try{
            iniciaOperacion();
            listaUsuarios = getSesion().createQuery("from Usuarios").list();
        }finally{
            getSesion().close();
        }
        return listaUsuarios;
    }
    
}
