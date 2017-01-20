/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.executor;

import com.rb.batch.core.validator.ValidateItem;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
@SuppressWarnings("ALL")
public class AbstractExecutor<T,O> implements Executor<T,O> {
    
    private boolean stopOnFail = false;
    
    protected ValidateItem<T> validator;
    
    protected ItemProcessor<T, O> itemProcessor;

    /**
     * <p>Constructor for AbstractExecutor.</p>
     */
    public AbstractExecutor() {
    }
    
    /**
     * <p>Constructor for AbstractExecutor.</p>
     *
     * @param validator a {@link com.rb.batch.core.validator.ValidateItem} object.
     * @param itemProcessor a {@link com.rb.batch.core.executor.ItemProcessor} object.
     */
    public AbstractExecutor(ValidateItem<T> validator, ItemProcessor<T, O> itemProcessor) {
        this.validator = validator;
        this.itemProcessor = itemProcessor;
    }
    
    
    
    
    /** {@inheritDoc} */
    @Override
    public Collection<O> processItems(Collection<T> all) {
        
        assert (validator !=null):"Validator Can not be Null" ;
        assert (itemProcessor !=null):"Item Processor Can not be Null";
                
        Collection<O> coll = new ArrayList<>();
        all.stream().filter((p) -> (validate(p) && !stopOnFail)).forEach((p) -> {
            coll.add(process(p));
        });
        
        return coll;
    }

    /**
     * <p>validate.</p>
     *
     * @param t a T object.
     * @return a boolean.
     */
    public boolean validate(T t){
        return validator.validate(t);
    } 
    
    /**
     * <p>process.</p>
     *
     * @param t a T object.
     * @return a O object.
     */
    public  O process(T t) {
        return itemProcessor.processItem(t);
    }

    /**
     * <p>isStopOnFail.</p>
     *
     * @return a boolean.
     */
    public boolean isStopOnFail() {
        return stopOnFail;
    }

    /**
     * <p>Setter for the field <code>stopOnFail</code>.</p>
     *
     * @param stopOnFail a boolean.
     */
    public void setStopOnFail(boolean stopOnFail) {
        this.stopOnFail = stopOnFail;
    }

    /**
     * <p>Getter for the field <code>validator</code>.</p>
     *
     * @return a {@link com.rb.batch.core.validator.ValidateItem} object.
     */
    public ValidateItem<T> getValidator() {
        return validator;
    }

    /**
     * <p>Setter for the field <code>validator</code>.</p>
     *
     * @param validator a {@link com.rb.batch.core.validator.ValidateItem} object.
     */
    public void setValidator(ValidateItem<T> validator) {
        this.validator = validator;
    }

    /**
     * <p>Getter for the field <code>itemProcessor</code>.</p>
     *
     * @return a {@link com.rb.batch.core.executor.ItemProcessor} object.
     */
    public ItemProcessor<T, O> getItemProcessor() {
        return itemProcessor;
    }

    /**
     * <p>Setter for the field <code>itemProcessor</code>.</p>
     *
     * @param itemProcessor a {@link com.rb.batch.core.executor.ItemProcessor} object.
     */
    public void setItemProcessor(ItemProcessor<T, O> itemProcessor) {
        this.itemProcessor = itemProcessor;
    }
       
    
    
}
