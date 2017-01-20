package com.rb.batch.repository;

import com.rb.batch.model.Person;

import javax.persistence.EntityManager;
import java.util.Collection;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonRepository {

    EntityManager em;

    /**
     * <p>Constructor for PersonRepository.</p>
     *
     * @param em a {@link javax.persistence.EntityManager} object.
     */
    public PersonRepository(EntityManager em) {
        this.em =em;

    }

    /**
     * <p>save.</p>
     *
     * @param p a {@link com.rb.batch.model.Person} object.
     */
    public void save(Person p){
        assert em!=null : "entity manager null, check configuration";
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
      //  em.close();
      //  em=null;
    }

    /**
     * <p>save.</p>
     *
     * @param personCollection a {@link java.util.Collection} object.
     * @param batchSize a int.
     */
    public void save(Collection<Person> personCollection, int batchSize){
        assert em!=null : "entity manager null, check configuration";
        em.getTransaction().begin();
        int i =0;
        for(Person person : personCollection)
        {
            em.persist(person);
            i++;
            if(i%batchSize ==0){
             em.flush();
             em.clear();
            }
        }
        em.getTransaction().commit();
     //   em.close();
     //   em=null;

    }


}
