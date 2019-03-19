/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Dependencias;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Adriana
 */
public class DependenciasDAO extends HibernateUtil implements IBaseDao <Dependencias,Integer>  {

    @Override
    public void save(Dependencias o) {
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
    public Dependencias merge(Dependencias o) {
         try{
             iniciaOperacion();
             o=(Dependencias) getSesion().merge(o);
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
    public void delete(Dependencias o) {
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
    public Dependencias findById(Integer o) {
        Dependencias dependencias = null;
        try{
            iniciaOperacion();
            dependencias = (Dependencias) getSesion().get(Dependencias.class,o);
        }finally{
            getSesion();
        }
        return dependencias;
    }

    @Override
    public List<Dependencias> findAll() {
         List<Dependencias> listaDependencias;
        try{
            iniciaOperacion();
            listaDependencias= getSesion().createQuery("from Dependencias").list();
        }finally{
            getSesion().close();
        }
        return listaDependencias;
    }
    
}
