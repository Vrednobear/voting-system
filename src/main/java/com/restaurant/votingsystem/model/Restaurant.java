package com.restaurant.votingsystem.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "RESTAURANTS")
public class Restaurant {

    @Id
    private Integer id;

    @Column
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    @OrderBy("price ASC")
    private List<Dish> menu;

    public Restaurant() {
    }

    public Restaurant(Integer id, String name, List<Dish> menu) {
        this.id = id;
        this.name = name;
        this.menu = menu;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Dish> getMenu() {
        return menu;
    }

    public void setMenu(List<Dish> menu) {
        this.menu = menu;
    }
}
