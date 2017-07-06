package net.antra.hanz.util;

import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by hanzheng on 7/5/17.
 */
public class EMFUtil {
    public static EntityManagerFactory getEMF(){
        return Persistence.createEntityManagerFactory("LoginServletDemo");
    }
}
