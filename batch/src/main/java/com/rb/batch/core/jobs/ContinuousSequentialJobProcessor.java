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
public class ContinuousSequentialJobProcessor<T,O>  extends JobProcessor<T, O> {

    private static int i =0;
    
    /**
     * <p>Constructor for ContinuousSequentialJobProcessor.</p>
     *
     * @param reader a {@link com.rb.batch.core.reader.Reader} object.
     * @param executor a {@link com.rb.batch.core.executor.Executor} object.
     * @param writer a {@link com.rb.batch.core.writer.BatchWriter} object.
     */
    public ContinuousSequentialJobProcessor(Reader<T> reader, Executor<T, O> executor, BatchWriter<O> writer) {
        super(reader, executor, writer);
    }

    /** {@inheritDoc} */
    @Override
    public void launchJob() {
        Thread readerThread = new Thread(new ReaderThread());
        readerThread.setName("ReaderThread");
        readerThread.start();
    }
    
    
    public class ReaderThread implements Runnable{

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true){
                Collection<T> readData = reader.readAndTransformFile();
                if(readData!=null){
                    writer.writeData(executor.processItems(readData));
                    i++;
                }
         
            if(i>100000){break;} 
                
        
            }
             System.out.println("Reader Time : "+(System.currentTimeMillis()-start));
        }
    }
}
