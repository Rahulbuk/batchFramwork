/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.executor;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public interface ItemProcessor<T,O> {
    
    /**
     * <p>processItem.</p>
     *
     * @param t a T object.
     * @return a O object.
     */
    O processItem(T t);
}
