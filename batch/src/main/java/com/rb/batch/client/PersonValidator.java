/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.client;

import com.rb.batch.model.Person;
import com.rb.batch.core.validator.ValidateItem;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonValidator implements ValidateItem<Person>{

    /** {@inheritDoc} */
    @Override
    public boolean validate(Person t) {

        return true;
    }
    
}
