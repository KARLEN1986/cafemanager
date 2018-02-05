package com.sfl.entity;

import javax.persistence.*;
import java.util.Set;
/**
 * Created by Karlen on 05.02.2018.
 */
@Entity
@Table(name = "product")
public class Product {

    private long id;
    private String name;
    private Set<Order> orderSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    @ManyToMany(mappedBy = "productSet")
    public Set<Order> getOrderSet() {
        return orderSet;
    }

    public void setOrderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderSet=" + orderSet +
                '}';
    }
}
