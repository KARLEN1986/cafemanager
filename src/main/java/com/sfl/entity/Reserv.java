package com.sfl.entity;

import javax.persistence.*;
import java.util.Set;
/**
 * Created by Karlen on 05.02.2018.
 */
@Entity
@Table(name = "reserv")
public class Reserv {

    private long Id;
    private Statuss statuss;
    private Set<Order> orderSet;
    private TableCafe tableByTableId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }


    @Column(name = "statuss")
    @Enumerated(EnumType.STRING)
    public Statuss getStatuss() {
        return statuss;
    }

    public void setStatuss(Statuss statuss) {
        this.statuss = statuss;
    }

    @ManyToOne
    @JoinColumn(name = "reserv_id", referencedColumnName = "id", nullable = true)
    public TableCafe gettableByTableId() {
        return tableByTableId;
    }

    public void settableByTableId(TableCafe tableByTableId) {
        this.tableByTableId = tableByTableId;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "orderproduct_reserv", joinColumns = @JoinColumn(name = "reserv_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"))
    public Set<Order> getorderSet() {
        return orderSet;
    }

    public void setorderSet(Set<Order> orderSet) {
        this.orderSet = orderSet;
    }

    @Override
    public String toString() {
        return "Reserv{" +
                "Id=" + Id +
                ", statuss=" + statuss +
                ", orderSet=" + orderSet +
                ", tableByTableId=" + tableByTableId +
                '}';
    }
}
