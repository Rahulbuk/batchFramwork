/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.jobs;

import com.rb.batch.core.executor.Executor;
import com.rb.batch.core.reader.Reader;
import com.rb.batch.core.writer.BatchWriter;
import com.rb.batch.core.writer.IWriter;


/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */

abstract class JobProcessor<T,O>  {

   protected Reader<T> reader;
   protected BatchWriter<O> writer;
   protected Executor<T, O> executor;

    /**
     * <p>Constructor for JobProcessor.</p>
     *
     * @param reader a {@link com.rb.batch.core.reader.Reader} object.
     * @param executor a {@link com.rb.batch.core.executor.Executor} object.
     * @param writer a {@link com.rb.batch.core.writer.BatchWriter} object.
     */
    public JobProcessor(Reader<T> reader, Executor<T, O> executor, BatchWriter<O> writer) {
        this.reader = reader;
        this.writer = writer;
        this.executor = executor;
    }

    /**
     * <p>Getter for the field <code>reader</code>.</p>
     *
     * @return a {@link com.rb.batch.core.reader.Reader} object.
     */
    public Reader<T> getReader() {
        return reader;
    }

    /**
     * <p>Setter for the field <code>reader</code>.</p>
     *
     * @param reader a {@link com.rb.batch.core.reader.Reader} object.
     */
    public void setReader(Reader<T> reader) {
        this.reader = reader;
    }

    /**
     * <p>Getter for the field <code>writer</code>.</p>
     *
     * @return a {@link com.rb.batch.core.writer.IWriter} object.
     */
    public IWriter<O> getWriter() {
        return writer;
    }

    /**
     * <p>Setter for the field <code>writer</code>.</p>
     *
     * @param writer a {@link com.rb.batch.core.writer.BatchWriter} object.
     */
    public void setWriter(BatchWriter<O> writer) {
        this.writer = writer;
    }

    /**
     * <p>Getter for the field <code>executor</code>.</p>
     *
     * @return a {@link com.rb.batch.core.executor.Executor} object.
     */
    public Executor<T, O> getExecutor() {
        return executor;
    }

    /**
     * <p>Setter for the field <code>executor</code>.</p>
     *
     * @param executor a {@link com.rb.batch.core.executor.Executor} object.
     */
    public void setExecutor(Executor<T, O> executor) {
        this.executor = executor;
    }

    /**
     * <p>launchJob.</p>
     */
    abstract protected void launchJob();


}
