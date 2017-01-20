/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.client;

import com.rb.batch.model.Person;
import com.rb.batch.core.reader.Reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */
public class PersonFileReader implements Reader<Person>{


    private static final Random random = new Random(3);

    private String filePath= "";

    /**
     * <p>Constructor for PersonFileReader.</p>
     *
     * @param filePath a {@link java.lang.String} object.
     */
    public PersonFileReader(String filePath) {
        this.filePath = filePath;
    }

    /** {@inheritDoc} */
    @Override
    public Collection<Person> readAndTransformFile()  {

        assert filePath !=null : "File path can not be null";
        List<Person> ret = new ArrayList<>();
        long start = System.currentTimeMillis();
        try {
        BufferedReader textFileReader = new BufferedReader(
                new InputStreamReader(getClass().getClassLoader().getResourceAsStream(filePath))
        );
        String recordLine;

        while((recordLine=textFileReader.readLine())!=null){
            String[] recordArray =recordLine.split(",");
            ret.add(new Person(recordArray[0].trim(),recordArray[1].trim(),recordArray[2].trim(),
                    Integer.parseInt(recordArray[3].trim())));
        }


            textFileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Reading time " + (System.currentTimeMillis() -start) );
        return ret;
    }
    
    
    
}
