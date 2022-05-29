package com.revature.mulberry.menu;

import java.util.List;

public class MenuServices {
    private final MenuDao menuDao;
    public MenuServices(MenuDao menuDao) {
        this.menuDao = menuDao;
    }
    public List<Menu> readAll() {
        return menuDao.findAll();
    }
    public Menu update(Menu updatedItem) {
        if(!menuDao.update(updatedItem)){
            return null;
        }

        return updatedItem;
    }
}
