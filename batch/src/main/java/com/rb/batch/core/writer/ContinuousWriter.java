/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.writer;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class ContinuousWriter<T> implements IWriter<T>{

    /** {@inheritDoc} */
    @Override
    public boolean writeData(T data) {
    

        return true;
    }
    
}
