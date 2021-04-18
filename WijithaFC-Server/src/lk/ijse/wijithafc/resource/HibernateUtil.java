/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.wijithafc.resource;

import java.io.File;
import lk.ijse.wijithafc.entity.Batch;
import lk.ijse.wijithafc.entity.GRN;
import lk.ijse.wijithafc.entity.GRNDetail;
import lk.ijse.wijithafc.entity.Item;
import lk.ijse.wijithafc.entity.ItemCategory;
import lk.ijse.wijithafc.entity.Login;
import lk.ijse.wijithafc.entity.Orders;
import lk.ijse.wijithafc.entity.OrderDetail;
import lk.ijse.wijithafc.entity.Payment;
import lk.ijse.wijithafc.entity.Supplier;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import sun.security.jgss.GSSUtil;

/**
 *
 * @author ASUS
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    private static StandardServiceRegistry registry;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            
            // (1) 
            File hibernateProperties = new File("settings/hibernate.properties");
            registry = new StandardServiceRegistryBuilder().loadProperties(hibernateProperties).build();
            
            // (2)
            sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(Item.class)
                    .addAnnotatedClass(Supplier.class)
                    .addAnnotatedClass(GRN.class)
                    .addAnnotatedClass(GRNDetail.class)
                    .addAnnotatedClass(Batch.class)
                    .addAnnotatedClass(Orders.class)
                    .addAnnotatedClass(OrderDetail.class)
                    .addAnnotatedClass(Login.class)
                    .addAnnotatedClass(Payment.class)
                    .addAnnotatedClass(ItemCategory.class)
            
                    .buildMetadata().buildSessionFactory();
            
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            
            StandardServiceRegistryBuilder.destroy(registry);
            
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
