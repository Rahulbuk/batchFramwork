/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.client;

import com.rb.batch.core.executor.ItemProcessor;
import com.rb.batch.model.Person;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonProcessor implements ItemProcessor<Person, Person>{

    /** {@inheritDoc} */
    @Override
    public Person processItem(Person t) {
            t.setName(t.getName()+" Processed");
        return t;
    }
    
}
