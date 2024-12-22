/*
* Copyright 2024 Riccardo Inverardi Galli
* Permission is hereby granted, free of charge, to any person obtaining a copy 
* of this software and associated documentation files (the “Software”), to deal 
* in the Software without restriction, including without limitation the rights 
* to use, copy, modify, merge, publish, distribute, sublicense, and/or sell 
* copies of the Software, and to permit persons to whom the Software is 
* furnished to do so, subject to the following conditions:
* The above copyright notice and this permission notice shall be included in 
* all copies or substantial portions of the Software.
*
* THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR 
* IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, 
* FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE 
* AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER 
* LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, 
* OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE 
* SOFTWARE.
*/
package com.mycompany.phonebook;
import java.util.UUID;

/**
 *
 * @author Riccardo Inverardi Galli
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

