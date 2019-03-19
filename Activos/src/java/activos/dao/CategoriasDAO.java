/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;

import activos.domain.Categorias;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author USUARIO
 */
public class CategoriasDAO extends HibernateUtil implements IBaseDao<Categorias, Integer>{

    @Override
    public void save(Categorias o) {
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
    public Categorias merge(Categorias o) {
        try{
            iniciaOperacion();
            o=(Categorias) getSesion().merge(o);
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
    public void delete(Categorias o) {
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
    public Categorias findById(Integer o) {
        Categorias categoria = null;
        try{
            iniciaOperacion();
            categoria = (Categorias) getSesion().get(Categorias.class, o);
        }finally{
            getSesion().close();
        }
        return categoria;
    }

    @Override
    public List<Categorias> findAll() {
        List<Categorias> list;
        try{
            iniciaOperacion();
            list=getSesion().createQuery("from Categorias").list();
        }finally{
            getSesion().close();
        }
        return list;
    }
    
}
