/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.client;

import com.rb.batch.core.executor.AbstractExecutor;
import com.rb.batch.core.executor.ItemProcessor;
import com.rb.batch.model.Person;
import com.rb.batch.core.validator.ValidateItem;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonExecutor extends AbstractExecutor<Person, Person>{

    /**
     * <p>Constructor for PersonExecutor.</p>
     */
    public PersonExecutor() {
        super();
    }

    /**
     * <p>Constructor for PersonExecutor.</p>
     *
     * @param validator a {@link com.rb.batch.core.validator.ValidateItem} object.
     * @param itemProcessor a {@link com.rb.batch.core.executor.ItemProcessor} object.
     */
    public PersonExecutor(ValidateItem<Person> validator, ItemProcessor<Person, Person> itemProcessor) {
        super(validator, itemProcessor);
    }

    
    
    /** {@inheritDoc} */
    @Override
    public boolean validate(Person t) {
     return super.validate(t);
    }

    
    
}
