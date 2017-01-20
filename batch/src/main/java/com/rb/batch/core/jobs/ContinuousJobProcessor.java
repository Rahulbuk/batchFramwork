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
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class ContinuousJobProcessor<T,O>  extends JobProcessor<T, O> {
    
    final Queue<Collection<T>> input = new ConcurrentLinkedQueue<>();
    final Queue<Collection<O>> output = new ConcurrentLinkedQueue<>();
    private static int i=0;
     private static int j=0;
      private static int k=0;
    
    /**
     * <p>Constructor for ContinuousJobProcessor.</p>
     *
     * @param reader a {@link com.rb.batch.core.reader.Reader} object.
     * @param executor a {@link com.rb.batch.core.executor.Executor} object.
     * @param writer a {@link com.rb.batch.core.writer.BatchWriter} object.
     */
    public ContinuousJobProcessor(Reader<T> reader, Executor<T, O> executor, BatchWriter<O> writer) {
        super(reader, executor, writer);
    }

    /** {@inheritDoc} */
    @Override
    public void launchJob() {
        Thread readerThread = new Thread(new ReaderThread());
        Thread executorThread = new Thread(new ExecutorThread());
        Thread writerThread = new Thread(new WriterThread());
        readerThread.setName("ReaderThread");
        executorThread.setName("ProceesorThread");
        writerThread.setName("WriterThread"); 
//        readerThread.setDaemon(true);
//        executorThread.setDaemon(true);
//        writerThread.setDaemon(true);
        readerThread.start();
        executorThread.start();
        writerThread.start();
        }
    
    
    public class ReaderThread implements Runnable{

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true){
                Collection<T> readData = reader.readAndTransformFile();
                if(readData!=null){
                     input.add(readData);
                     i++;
                }
          //  try {Thread.sleep(0, 10);} catch (InterruptedException ex) {ex.printStackTrace();}
            if(i>100000){break;
            } 
                
        
            }
             System.out.println("Reader Time : "+(System.currentTimeMillis()-start));
        }
    }
    
    
    public class ExecutorThread implements Runnable{

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true){
              Collection<T> readData = input.poll();
              if(readData!=null){
                     output.add(executor.processItems(readData));
                      j++;
              }
            //   try {Thread.sleep(0, 10);} catch (InterruptedException ex) {ex.printStackTrace();}
               if(j>100000){break; }
            }
             System.out.println("Processor Time : "+(System.currentTimeMillis()-start));
        }
    }
    
    
    public class WriterThread implements Runnable{

        @Override
        public void run() {
            long start = System.currentTimeMillis();
            while (true){
                 if(output.size()==0){
                     try {Thread.sleep(0, 100);} catch (InterruptedException ex) {ex.printStackTrace();}
                 } 
                Collection<O> readData = output.poll();
                if(readData!=null){
                 writer.writeData(readData);
                 k++;
                }
               if(k>100000){break; }
            }
            System.out.println("Write Time : "+(System.currentTimeMillis()-start));
        }
    }

}
