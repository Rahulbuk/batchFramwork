package com.rb.batch.repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersistenceManager {

    private EntityManagerFactory factory;

    private static  PersistenceManager manager = null;

    private static final ThreadLocal<EntityManager> entityManagers =new ThreadLocal<>();


    private PersistenceManager() {
        factory = Persistence.createEntityManagerFactory("person_batch") ;
    }

    /**
     * <p>getInstance.</p>
     *
     * @return a {@link com.rb.batch.repository.PersistenceManager} object.
     */
    public  static  PersistenceManager getInstance(){
        if(manager ==null) {
            manager = new PersistenceManager();
        }

         return manager;

    }

    /**
     * <p>getEntityManager.</p>
     *
     * @return a {@link javax.persistence.EntityManager} object.
     */
    public EntityManager getEntityManager(){
        EntityManager em = entityManagers.get();

        if(em==null){
            em = factory.createEntityManager();
            entityManagers.set(em);
        }

        return  em;

    }
}
