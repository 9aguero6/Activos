/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package activos.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author USUARIO
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private Transaction trans;
    private Session sesion;
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public Transaction getTrans() {
        return trans;
    }

    public Session getSesion() {
        return sesion;
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public void iniciaOperacion() throws HibernateException{
        this.sesion=HibernateUtil.getSessionFactory().openSession();
        this.trans=sesion.beginTransaction();
    }
    public void manejaException(HibernateException he) throws HibernateException{
        trans.rollback();
        throw new HibernateException("Error",he);
    }
}
