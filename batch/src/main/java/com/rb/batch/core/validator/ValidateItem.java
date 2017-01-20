/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.validator;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public interface ValidateItem <T> {
    
  /**
   * <p>validate.</p>
   *
   * @param t a T object.
   * @return a boolean.
   */
  boolean validate(T t);
    
}
