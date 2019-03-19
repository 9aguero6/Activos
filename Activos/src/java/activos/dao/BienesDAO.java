/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.dao;
import activos.domain.Bienes;
import activos.utils.HibernateUtil;
import java.util.List;
import org.hibernate.HibernateException;
/**
 *
 * @author USUARIO
 */
public class BienesDAO extends HibernateUtil implements IBaseDao <Bienes, Integer> {

    @Override
    public void save(Bienes o) {
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
    public Bienes merge(Bienes o) {
        try{
            iniciaOperacion();
            o=(Bienes) getSesion().merge(o);
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
    public void delete(Bienes o) {
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
    public Bienes findById(Integer o) {
        Bienes bienes=null;
        
        try{
            iniciaOperacion();
            bienes=(Bienes) getSesion().get(Bienes.class, o);
        }finally{
            
        }
        return bienes;
    }

    @Override
    public List<Bienes> findAll() {
       List<Bienes> list;
        try{
            iniciaOperacion();
            list=getSesion().createQuery("from Bienes").list();
        }finally{
            getSesion().close();
        }
        return list;
    }
    
}
