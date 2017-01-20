/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rb.batch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

/**
 * @author bhandwalkarr
 * @version $Id: $Id
 */

@Entity
@Table(name = "Person")
public class Person {

    @Id
    @Column(name = "Id", nullable = false)
    private String id;
    @Column(name = "First_Name")
    private String name;
    @Column(name = "Last_Name")
    private String lastName;
    @Column(name = "Country")
    private String country;
    @Column(name = "Age")
    private int age ;

    /**
     * <p>Constructor for Person.</p>
     */
    public Person() {
        this.id= UUID.randomUUID().toString();
    }

    
    /**
     * <p>Constructor for Person.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param lastName a {@link java.lang.String} object.
     * @param country a {@link java.lang.String} object.
     * @param age a int.
     */
    public Person(String name, String lastName, String country, int age) {
        this.id= UUID.randomUUID().toString();
        this.name = name;
        this.lastName = lastName;
        this.country = country;
        this.age = age;
    }

    /**
     * <p>Getter for the field <code>id</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getId() {
        return id;
    }

    /**
     * <p>Getter for the field <code>name</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getName() {
        return name;
    }

    /**
     * <p>Setter for the field <code>name</code>.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * <p>Getter for the field <code>lastName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * <p>Setter for the field <code>lastName</code>.</p>
     *
     * @param lastName a {@link java.lang.String} object.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * <p>Getter for the field <code>country</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getCountry() {
        return country;
    }

    /**
     * <p>Setter for the field <code>country</code>.</p>
     *
     * @param country a {@link java.lang.String} object.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * <p>Getter for the field <code>age</code>.</p>
     *
     * @return a int.
     */
    public int getAge() {
        return age;
    }

    /**
     * <p>Setter for the field <code>age</code>.</p>
     *
     * @param age a int.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", lastName=" + lastName + ", country=" + country + ", age=" + age + '}';
    }
   
    
    
}
