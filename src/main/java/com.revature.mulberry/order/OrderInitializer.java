package com.revature.mulberry.order;

public class OrderInitializer {

    private int id;
    private String menu_item;
    private String comment;
    private boolean is_favorite;
    private String order_date;

    public OrderInitializer() {}

    public OrderInitializer(int id, String menu_item, String comment, boolean is_favorite, String order_date) {
        this.id = id;
        this.menu_item = menu_item;
        this.comment = comment;
        this.is_favorite = is_favorite;
        this.order_date = order_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(String menu_item) {
        this.menu_item = menu_item;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public boolean isIs_favorite() {
        return is_favorite;
    }

    public void setIs_favorite(boolean is_favorite) {
        this.is_favorite = is_favorite;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }
}
