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
}
