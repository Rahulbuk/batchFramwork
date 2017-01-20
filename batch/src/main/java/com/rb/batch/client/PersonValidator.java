/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.client;

import com.rb.batch.model.Person;
import com.rb.batch.core.validator.ValidateItem;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonValidator implements ValidateItem<Person>{

    /** {@inheritDoc} */
    @Override
    public boolean validate(Person t) {
     //   EuroCCP.println("Validating Item : "+t);
        //try {Thread.sleep(500);} catch (InterruptedException ex) {  }
        return true;
    }
    
}
