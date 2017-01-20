/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch;

import com.rb.batch.scheduler.JobScheduler;
import com.rb.batch.scheduler.QuartzSequentialJob;
import org.quartz.SchedulerException;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
@SuppressWarnings("unchecked")
public class MainBatch {

    /**
     * <p>main.</p>
     *
     * @param args an array of {@link java.lang.String} objects.
     * @throws org.quartz.SchedulerException if any.
     */
    public static void main(String[] args) throws SchedulerException {

        // TODO provide valid <code>CronExpression</code> string to this method
        JobScheduler scheduler = new JobScheduler(QuartzSequentialJob.class, null);
        scheduler.start();

    }

}
