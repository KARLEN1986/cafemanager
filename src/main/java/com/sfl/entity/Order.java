package com.sfl.entity;

import javax.persistence.*;
import java.util.Set;
/**
 * Created by Karlen on 05.02.2018.
 */
@Entity
@Table(name = "order")
public class Order {
    private long id;
    private int amount;
    private Set<Product> productSet;
    private Set<Reserv> reservSet;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_in_order", joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id"))
    public Set<Product> getProductSet() {
        return productSet;
    }
    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }


    @ManyToMany(mappedBy = "orderSet")
    public Set<Reserv> getReservSet() {
        return reservSet;
    }

    public void setReservSet(Set<Reserv> reservSet) {
        this.reservSet = reservSet;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", amount=" + amount +
                ", productSet=" + productSet +
                ", reservSet=" + reservSet +
                '}';
    }
}

