/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.reader;

import java.util.Collection;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public interface Reader <T> {

    
    /**
     * <p>readAndTransformFile.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    Collection<T> readAndTransformFile();
}
