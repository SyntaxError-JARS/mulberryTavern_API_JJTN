package com.revature.mulberry.order;

public class OrderServices {

    private OrderDao orderDao;

    public OrderServices(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    public Orders create(Orders newOrder) {

        Orders persistedOrder = orderDao.create(newOrder);
        return persistedOrder;
    }
}