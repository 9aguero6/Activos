/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Barras;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
public class BarrasDAO extends HibernateUtil implements IBaseDao<Barras, Integer>{

    @Override
    public void save(Barras o) {
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
    public Barras merge(Barras o) {
        try{
            iniciaOperacion();
            o = (Barras)getSesion().merge(o);
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
    public void delete(Barras o) {
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
    public Barras findById(Integer o) {
        Barras barra = null;
        try{
            iniciaOperacion();
            barra = (Barras)getSesion().get(Barras.class, o);
        }finally{
            getSesion().close();
        }
        return barra;
    }

    @Override
    public List<Barras> findAll() {
        List<Barras> list;
        try{
            iniciaOperacion();
            list = getSesion().createQuery("from Barras").list();
        }finally{
            getSesion().close();
        }
        return list;
    }
    
}
