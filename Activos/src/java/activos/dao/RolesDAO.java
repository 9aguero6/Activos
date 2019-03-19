/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;


import activos.domain.Roles;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Adriana
 */
public class RolesDAO extends HibernateUtil implements IBaseDao <Roles, Integer> {

    @Override
    public void save(Roles o) {
         try{
            iniciaOperacion();
            getSesion().save(o);
            getTrans().commit();
        }catch(HibernateException he){
           manejaException(he);
           throw he;
        }finally{
            getSesion().close();
        }
    }

    @Override
    public Roles merge(Roles o) throws HibernateException {
         try{
             iniciaOperacion();
             o=(Roles) getSesion().merge(o);
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
    public void delete(Roles o) {
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
    public Roles findById(Integer o) {
        Roles roles = null;
        try{
            iniciaOperacion();
            roles = (Roles) getSesion().get(Roles.class,o);
        }finally{
            getSesion();
        }
        return roles;
    }

    @Override
    public List<Roles> findAll() {
        List<Roles> listaRoles;
        try{
            iniciaOperacion();
            listaRoles = getSesion().createQuery("from Roles").list();
        }finally{
            getSesion().close();
        }
        return listaRoles;
    }
    
}
