package com.revature.mulberry.customer;

import java.io.IOException;
import java.util.List;

public class CustomerServices {

    private CustomerDao customerDao;

    public CustomerServices(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public Customer create(Customer newCustomer){

        Customer persistedCustomer = customerDao.create(newCustomer);
        return persistedCustomer;
    }
    public Customer authenticateAdmin(String username, String password){

        if(password == null || password.trim().equals("") || username == null || username.trim().equals("")) {
            throw new RuntimeException();
        }

        Customer authenticatedAdmin = customerDao.authenticateAdmin(username, password);

        if (authenticatedAdmin == null){
            throw new RuntimeException();
        }

        return authenticatedAdmin;

    }
    public Customer authenticateCustomer(String username, String password){

        if(password == null || password.trim().equals("") || username == null || username.trim().equals("")) {
            throw new RuntimeException();
        }

        Customer authenticatedCustomer = customerDao.authenticateCustomer(username, password);

        if (authenticatedCustomer == null){
            throw new RuntimeException();
        }

        return authenticatedCustomer;

    }
}
