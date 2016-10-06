/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aviara.stock.bean;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author comp2
 */
@Entity
@Table(name = "supplier")
public class Supplier implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @Column(name = "supplier_fname")
    private String fname;
    
    @Column(name = "supplier_lname")
    private String lname;
    
    @Column(name = "supplier_email")
    private String email;
    
    @Column(name = "supplier_state")
    private String state;
    
    @Column(name = "supplier_city")
    private String city;
    
    @Column(name = "supplier_address")
    private String address;
    
    @Column(name = "supplier_pincode")
    private String pincode;
    
    @Column(name = "supplier_contact")
    private String contact;

    public int getId() {
        return id;
    }

    
    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    public String getPincode() {
        return pincode;
    }

    public String getContact() {
        return contact;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    
    
}
