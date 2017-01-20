/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.client;

import com.rb.batch.repository.PersonRepository;
import com.rb.batch.model.Person;
import com.rb.batch.core.writer.BatchWriter;

import java.util.Collection;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonWriter implements BatchWriter<Person> {

    private PersonRepository personRepository;

    /**
     * <p>Constructor for PersonWriter.</p>
     *
     * @param personRepository a {@link com.rb.batch.repository.PersonRepository} object.
     */
    public PersonWriter(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /** {@inheritDoc} */
    @Override
    public boolean writeData(Collection<Person> data) {

        personRepository.save(data, 5000);
        return true;
    }

    /** {@inheritDoc} */
    @Override
    public boolean writeData(Person data) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
