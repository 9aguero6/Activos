/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Activos;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
public class ActivosDAO extends HibernateUtil implements IBaseDao<Activos, Integer>{

    @Override
    public void save(Activos o) {
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
    public Activos merge(Activos o) {
        try{
            iniciaOperacion();
            o=(Activos) getSesion().merge(o);
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
    public void delete(Activos o) {
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
    public Activos findById(Integer o) {
        Activos activo = null;
        try{
            iniciaOperacion();
            activo = (Activos) getSesion().get(Activos.class, o);
        }finally{
            getSesion().close();
        }
        return activo;
    }

    @Override
    public List<Activos> findAll() {
        List<Activos> list;
        try{
            iniciaOperacion();
            list=getSesion().createQuery("from Activos").list();
        }finally{
            getSesion().close();
        }
        return list;
    }
    
}
