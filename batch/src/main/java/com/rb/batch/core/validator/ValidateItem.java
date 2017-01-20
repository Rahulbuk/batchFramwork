/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.validator;

/**
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
