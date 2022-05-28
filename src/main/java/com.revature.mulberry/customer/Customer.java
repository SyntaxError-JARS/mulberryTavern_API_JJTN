package com.revature.mulberry.customer;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "customer", schema = "mulberry")
public class Customer {

    private String fname;
    private String lname;
    @Id
    private String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private double balance;
    private boolean is_admin;

    public Customer(String fname, String lname, String username, String password,
                    double balance, boolean is_admin) {
        super();
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.balance = balance;
        this.is_admin = is_admin;
    }

    public Customer(String password){
        this.password = password;
    }

    public Customer() {}

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isIs_admin() {
        return is_admin;
    }

    public void setIs_admin(boolean is_admin) {
        this.is_admin = is_admin;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                ", is_admin=" + is_admin +
                '}';
    }
}


