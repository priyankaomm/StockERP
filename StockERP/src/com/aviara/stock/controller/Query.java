/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.controller;

 
import com.aviara.stock.bean.Supplier;
import org.hibernate.Session; 
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author comp2
 */
public class Query {
    public void save(Supplier stock)
    {
        try{
         
        Session sessionOne = getTransaction();
        sessionOne.beginTransaction();
        sessionOne.persist(stock);
        sessionOne.getTransaction().commit();
        sessionOne.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    private Session getTransaction()
    {
        
        Session session=null;
        try{
       
        //creating seession factory object  
        SessionFactory factory = new AnnotationConfiguration().
                   addPackage("com.aviara.stock.bean").
                   addAnnotatedClass(Supplier.class).
                   configure("com/aviara/stock/configuration/hibernate.cfg.xml").buildSessionFactory();
        
        //creating session object  
        session=factory.openSession();  
      
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        return session;
    }
}
