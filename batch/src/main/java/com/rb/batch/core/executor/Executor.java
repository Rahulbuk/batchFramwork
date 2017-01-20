/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.executor;

import java.util.Collection;

 /**
  * @author bhandwalkarr
  * @version $Id: $Id
  */
 public interface Executor <T, O> {
     
     /**
      * <p>processItems.</p>
      *
      * @param t a {@link java.util.Collection} object.
      * @return a {@link java.util.Collection} object.
      */
     Collection<O> processItems(Collection<T> t);
    
}
