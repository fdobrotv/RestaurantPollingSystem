package com.fdobrotv.rps.models;

/**
 * Created by Fedor Dobrotvorsky on 04.11.2016.
 */
import com.fdobrotv.rps.models.base.NamedEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "lunch", uniqueConstraints = {@UniqueConstraint(columnNames = {"menu_id", "name"}, name = "unique_lunch")})
public class Lunch extends NamedEntity {

    @Column(name = "price", nullable = false)
    private int price;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "menu_id", nullable = false)
    @NotNull
    private Menu menu;

    public Lunch() {
    }

    public Lunch(Long id, String name, int priceInCents) {
        super(id, name);
        this.price = priceInCents;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    @Override
    public String toString() {
        return "Lunch (" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", price=" + price +
                ')';
    }
}