package com.revature.mulberry.order;

import com.revature.mulberry.customer.Customer;
import com.revature.mulberry.menu.Menu;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;


    @ManyToOne(optional = false)
    @JoinColumn(name = "menu_item", referencedColumnName = "item_name")
    private Menu menu_item;

    private String comment;

    private boolean is_favorite;

    private String order_date;

    @ManyToOne(optional = false)
    @JoinColumn(name = "customer_username", referencedColumnName = "username")
    private Customer customer_username;
    public Orders() {}

    public Orders(int id, Menu menu_item, String comment, boolean is_favorite, String order_date,
                  Customer customer_username) {
        super();
        this.id = id;
        this.menu_item = menu_item;
        this.comment = comment;
        this.is_favorite = is_favorite;
        this.order_date = order_date;
        this.customer_username = customer_username;
    }

    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", menu_item=" + menu_item.getItem_name() +
                ", comment='" + comment + '\'' +
                ", is_favorite=" + is_favorite +
                ", order_date='" + order_date + '\'' +
                ", customer_username=" + customer_username.getUsername() +
                "}";
    }

    public String idToString() {
        return " " + id + " ";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Orders)) return false;
        Orders orders = (Orders) o;
        return id == orders.id && is_favorite == orders.is_favorite && menu_item.equals(orders.menu_item)
                && Objects.equals(comment, orders.comment) && order_date.equals(orders.order_date)
                && customer_username.equals(orders.customer_username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, menu_item, comment, is_favorite, order_date, customer_username);
    }

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
}

