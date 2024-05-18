package com.revature.mulberry.creditcard;

public class CCInitializer {

    private String cc_number;
    private String cc_name;
    private int cvv;
    private String exp_date;
    private int zip;
//    private double limit;

    public CCInitializer() {}

    public CCInitializer(String cc_number, String cc_name, int cvv, String exp_date, int zip) {
        this.cc_number = cc_number;
        this.cc_name = cc_name;
        this.cvv = cvv;
        this.exp_date = exp_date;
        this.zip = zip;

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

}
