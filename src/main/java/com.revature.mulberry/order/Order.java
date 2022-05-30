package com.revature.mulberry.order;

import com.revature.mulberry.customer.Customer;
import com.revature.mulberry.menu.Menu;
import javax.persistence.*;

@Entity
@Table(name = "order")
public class Order {

    @Id
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name="menu", referencedColumnName = "item_name")
    private Menu menu_item;

    private String comment;

    private boolean is_favorite;

    private String order_date;

    @ManyToOne(optional = false)
    @JoinColumn(name="customer", referencedColumnName = "username")
    private Customer customer_username;

    public Order() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Menu getMenu_item() {
        return menu_item;
    }

    public void setMenu_item(Menu menu_item) {
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

    public Customer getCustomer_username() {
        return customer_username;
    }

    public void setCustomer_username(Customer customer_username) {
        this.customer_username = customer_username;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", menu_item=" + menu_item +
                ", comment='" + comment + '\'' +
                ", is_favorite=" + is_favorite +
                ", order_date='" + order_date + '\'' +
                ", customer_username=" + customer_username +
                '}';
    }
}
