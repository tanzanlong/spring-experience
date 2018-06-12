package com.tan.spring.tech.ioc.bean.cirref;

public class AccountService {
    private OrderService orderService;

    public OrderService getOrderService() {
        return orderService;
    }

    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }


}
