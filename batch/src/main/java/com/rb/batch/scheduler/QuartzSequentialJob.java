package com.rb.batch.scheduler;

import com.rb.batch.client.PersonFileReader;
import com.rb.batch.client.PersonValidator;
import com.rb.batch.client.PersonExecutor;
import com.rb.batch.client.PersonWriter;
import com.rb.batch.client.PersonProcessor;
import com.rb.batch.repository.PersistenceManager;
import com.rb.batch.repository.PersonRepository;
import com.rb.batch.core.jobs.SequentialJobProcessor;
import com.rb.batch.core.executor.Executor;
import com.rb.batch.model.Person;
import com.rb.batch.core.reader.Reader;
import com.rb.batch.core.writer.BatchWriter;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.persistence.EntityManager;

/**
 * Created by rahul.b.uk on 1/20/17.
 *
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class QuartzSequentialJob implements Job {


    /** {@inheritDoc} */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        // TODO externalize location
        Reader<Person> reader = new PersonFileReader("payload.txt");
        EntityManager em = PersistenceManager.getInstance().getEntityManager();

        BatchWriter<Person> writer = new PersonWriter(new PersonRepository(em));

        Executor<Person, Person> executor = new PersonExecutor(new PersonValidator(), new PersonProcessor());

        new SequentialJobProcessor<>(reader, executor, writer).launchJob();

    }
}
