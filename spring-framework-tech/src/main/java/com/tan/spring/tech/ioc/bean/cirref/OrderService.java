package com.tan.spring.tech.ioc.bean.cirref;

public class OrderService {

    private AccountService accountService;

    public AccountService getAccountService() {
        return accountService;
    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }


}
