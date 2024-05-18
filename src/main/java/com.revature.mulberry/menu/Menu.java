package com.revature.mulberry.menu;

import javax.persistence.*;

@Entity
@Table(name = "menu")
public class Menu {

    @Id
    private String item_name;
	private double cost;
    private String protein;
    private boolean is_substitutable;

    public Menu(String item_name, double cost, String protein, boolean is_substitutable) {
        super();
        this.item_name = item_name;
        this.cost = cost;
        this.protein = protein;
        this.is_substitutable = is_substitutable;
    }

    public Menu() {}

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProtein() {
        return protein;
    }

    public void setProtein(String protein) {
        this.protein = protein;
    }

    public boolean isIs_substitutable() {
        return is_substitutable;
    }

    public void setIs_substitutable(boolean is_substitutable) {
        this.is_substitutable = is_substitutable;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "item_name='" + item_name + '\'' +
                ", cost=" + cost +
                ", protein='" + protein + '\'' +
                ", is_substitutable=" + is_substitutable +
                '}';
    }
}
