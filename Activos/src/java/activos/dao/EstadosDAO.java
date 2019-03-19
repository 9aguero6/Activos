/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Estados;
import activos.utils.HibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;

/**
 *
 * @author USUARIO
 */
public class EstadosDAO extends HibernateUtil implements IBaseDao <Estados, Integer> {

    @Override
    public void save(Estados o) {
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
    public Estados merge(Estados o) {
        try{
            iniciaOperacion();
            o=(Estados) getSesion().merge(o);
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
    public void delete(Estados o) {
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
    public Estados findById(Integer o) {
        Estados estados=null;
        
        try{
            iniciaOperacion();
            estados=(Estados) getSesion().get(Estados.class, o);
        }finally{
            
        }
        return estados;
    }

    @Override
    public List<Estados> findAll() {
        List<Estados> list;
        try{
            iniciaOperacion();
            list=getSesion().createQuery("from Estados").list();
        }finally{
            getSesion().close();
        }
        return list;
    }

 
    
}
