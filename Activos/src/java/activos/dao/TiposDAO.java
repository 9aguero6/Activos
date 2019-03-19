/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Tipos;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author Adriana
 */
public class TiposDAO extends HibernateUtil implements IBaseDao <Tipos,Integer>  {

    @Override
    public void save(Tipos o) {
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
    public Tipos merge(Tipos o) {
         try{
             iniciaOperacion();
             o=(Tipos) getSesion().merge(o);
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
    public void delete(Tipos o) {
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
    public Tipos findById(Integer o) {
       Tipos tipos = null;
        try{
            iniciaOperacion();
            tipos = (Tipos) getSesion().get(Tipos.class,o);
        }finally{
            getSesion();
        }
        return tipos;
    }

    @Override
    public List<Tipos> findAll() {
         List<Tipos> listaTipos;
        try{
            iniciaOperacion();
            listaTipos= getSesion().createQuery("from Tipos").list();
        }finally{
            getSesion().close();
        }
        return listaTipos;
    }
    
}
