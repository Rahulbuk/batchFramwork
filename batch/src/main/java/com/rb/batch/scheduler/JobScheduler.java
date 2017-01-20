package com.rb.batch.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class JobScheduler {

    private Trigger trigger;

    private Scheduler scheduler;

    private JobDetail job;


    /**
     * <p>Constructor for JobScheduler.</p>
     *
     * @param job a {@link java.lang.Class} object.
     * @param cronSchedule a {@link java.lang.String} object.
     * @throws org.quartz.SchedulerException if any.
     */
    public JobScheduler(Class<? extends Job> job, String cronSchedule) throws SchedulerException {
        this.scheduler = new StdSchedulerFactory("quartz.properties").getScheduler();
        this.job =JobBuilder.newJob(job).build();

        if (cronSchedule == null || "".equals(cronSchedule)) {
            trigger = TriggerBuilder.newTrigger()
                    .withIdentity(job.getClass().getName())
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().repeatForever()
                            .withIntervalInSeconds(100))
                    .withPriority(1)
                    .build();

        } else {
            try {
                CronExpression e = new CronExpression(cronSchedule);

                trigger = TriggerBuilder.newTrigger()
                        .withIdentity(job.getClass().getName())
                        .withSchedule(CronScheduleBuilder.cronSchedule(e))
                        .build();
            } catch (ParseException e1) {
                throw new IllegalArgumentException("Invalid Cron Schedule");
            }
        }

    }

    /**
     * <p>start.</p>
     *
     * @throws org.quartz.SchedulerException if any.
     */
    public void start() throws SchedulerException {
        scheduler.start();
        scheduler.scheduleJob(job, trigger);

    }
}
