package com.revature.mulberry.creditcard;

import com.revature.mulberry.customer.Customer;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "credit_card")
public class CreditCard {

    @Id
    @Column(name = "cc_number")
    private String cc_number;

    private String cc_name;

    private int cvv;

    private String exp_date;

    private int zip;

//    @Column(name = "limit")
//    private double limit;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_username", referencedColumnName = "username")
    private Customer customer_username;

    public CreditCard() {}

    public String lastFourDigits() {
        return cc_number.substring(12);
    }

    public CreditCard(String cc_number, String cc_name, int cvv, String exp_date, int zip,
                      Customer customer_username) {
        this.cc_number = cc_number;
        this.cc_name = cc_name;
        this.cvv = cvv;
        this.exp_date = exp_date;
        this.zip = zip;
        this.customer_username = customer_username;
    }

    public String getCc_number() {
        return cc_number;
    }

    public void setCc_number(String cc_number) {
        this.cc_number = cc_number;
    }

    public String getCc_name() {
        return cc_name;
    }

    public void setCc_name(String cc_name) {
        this.cc_name = cc_name;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExp_date() {
        return exp_date;
    }

    public void setExp_date(String exp_date) {
        this.exp_date = exp_date;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public Customer getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(Customer customer_username) {
        this.customer_username = customer_username;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cc_number='" + cc_number + '\'' +
                ", cc_name='" + cc_name + '\'' +
                ", cvv=" + cvv +
                ", exp_date='" + exp_date + '\'' +
                ", zip=" + zip +
                ", customer_username=" + customer_username +
                '}';
    }
}
