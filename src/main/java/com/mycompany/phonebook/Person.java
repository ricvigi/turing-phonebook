/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phonebook;
import java.util.UUID;

/**
 *
 * @author rick
 */
public class Person {
    
    public final String id;
    public String name = null;
    public String surname = null;
    public String address = null;
    public String phone = null;
    public int age = -1;
    
    public Person()
    {
        this.id = UUID.randomUUID().toString();
    }
    protected void setName(String name) {this.name = name;}
    protected void setSurname (String surname) {this.surname = surname;}
    protected void setAddress (String address) {this.address = address;}
    protected void setPhone (String phone) {this.phone = phone;}
    protected void setAge (int age) {this.age = age;}
    protected String getId() {return this.id;}
    protected String getName(){return this.name;}
    protected String getSurname() {return this.surname;}
    protected String getAddress() {return this.address;}
    protected String getPhone() {return this.phone;}
    protected int getAge() {return this.age;}
}

