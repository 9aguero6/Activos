/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Comprobante;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
public class ComprobantesDAO extends HibernateUtil implements IBaseDao <Comprobante, Integer> {

    @Override
    public void save(Comprobante o) {
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
    public Comprobante merge(Comprobante o) {
      try{
            iniciaOperacion();
            o=(Comprobante) getSesion().merge(o);
            getTrans().commit();
        }catch(HibernateException he){
            manejaException(he);
            throw he;
        }finally{
            getSesion().close();
        }
        return o;
    }

    @Override
    public void delete(Comprobante o) {
        try{
            iniciaOperacion();
            getSesion().delete(o);
            getTrans().commit();
        }catch(HibernateException he){
            manejaException(he);
            throw he;
        }finally{
            getSesion().close();
        }
    }

    @Override
    public Comprobante findById(Integer o) {
        Comprobante comprobante=null;
        
        try{
            iniciaOperacion();
            comprobante=(Comprobante) getSesion().get(Comprobante.class, o);
        }finally{
            
        }
        return comprobante;
    }

    @Override
    public List<Comprobante> findAll() {
        List<Comprobante> list;
        try{
            iniciaOperacion();
            list=getSesion().createQuery("from Comprobante").list();
        }finally{
            getSesion().close();
        }
        return list;
    }
    
}
