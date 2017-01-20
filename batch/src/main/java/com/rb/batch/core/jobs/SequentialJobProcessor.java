/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.core.jobs;

import com.rb.batch.core.executor.Executor;
import com.rb.batch.core.jobs.JobProcessor;
import com.rb.batch.core.reader.Reader;
import com.rb.batch.core.writer.BatchWriter;

import java.util.Collection;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class SequentialJobProcessor <T, O> extends JobProcessor<T, O> {

    /**
     * <p>Constructor for SequentialJobProcessor.</p>
     *
     * @param reader a {@link com.rb.batch.core.reader.Reader} object.
     * @param executor a {@link com.rb.batch.core.executor.Executor} object.
     * @param writer a {@link com.rb.batch.core.writer.BatchWriter} object.
     */
    public SequentialJobProcessor(Reader<T> reader, Executor<T, O> executor, BatchWriter<O> writer) {
        super(reader, executor, writer);
    }

    /** {@inheritDoc} */
    @Override
   public  void launchJob(){

        long startTime =System.currentTimeMillis();

        try {
            Collection<T> data =  reader.readAndTransformFile();
            Collection<O> output  =executor.processItems(data);
            writer.writeData(output);

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Time ="+(System.currentTimeMillis()-startTime)/1000 + " Seconds");
       
    }
    
}
