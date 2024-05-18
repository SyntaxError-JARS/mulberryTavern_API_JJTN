package com.revature.mulberry.creditcard;

public class CCServices {

    private CCDao ccDao;

    public CCServices(CCDao ccDao) {
        this.ccDao = ccDao;
    }

    public CreditCard create(CreditCard newCC) {
        CreditCard persistedCC = ccDao.create(newCC);
        return persistedCC;
    }
}
