/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.phonebook;

/**
 *
 * @author rick
 */
public class Person {
    public String name = null;
    public String surname = null;
    public String address = null;
    public String phone = null;
    public int age = -1;
    
    public Person()
    {
    }
    private void setName(String name) {this.name = name;}
    private void setSurname (String surname) {this.surname = surname;}
    private void setAddress (String address) {this.address = address;}
    private void setPhone (String phone) {this.phone = phone;}
    private void setAge (int age) {this.age = age;}
}

