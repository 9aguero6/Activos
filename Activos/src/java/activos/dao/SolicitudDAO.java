/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;
import activos.domain.Solicitud;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
/**
 *
 * @author USUARIO
 */
public class SolicitudDAO extends HibernateUtil implements IBaseDao <Solicitud, Integer> {

    @Override
    public void save(Solicitud o) {
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
    public Solicitud merge(Solicitud o) {
       try{
            iniciaOperacion();
            o=(Solicitud) getSesion().merge(o);
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
    public void delete(Solicitud o) {
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
    public Solicitud findById(Integer o) {
       Solicitud solicitud=null;
        
        try{
            iniciaOperacion();
            solicitud=(Solicitud) getSesion().get(Solicitud.class, o);
        }finally{
            
        }
        return solicitud;
    }

    @Override
    public List<Solicitud> findAll() {
      List<Solicitud> list;
        try{
            iniciaOperacion();
            list=getSesion().createQuery("from Solicitud").list();
        }finally{
            getSesion().close();
        }
        return list;
    }
    
}
