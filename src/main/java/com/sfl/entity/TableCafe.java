package com.sfl.entity;

import javax.persistence.*;
/**
 * Created by Karlen on 05.02.2018.
 */
@Entity
@Table(name = "table_cafe")
public class TableCafe {
    private long id;
    private String name;
    private Reserv reservByReservId;
    private User userByUserId;
    private Statuss statuss;

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
    public Reserv getReservByReservId() {
        return reservByReservId;
    }
    public void setReservByReservId(Reserv reservByReservId) {
        this.reservByReservId = reservByReservId;
    }


    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = true)
    public User getUserByUserId() {
        return userByUserId;
    }

    public void setUserByUserId(User userByUserId) {
        this.userByUserId = userByUserId;
    }

    @Override
    public String toString() {
        return "TableCafe{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", reservByReservId=" + reservByReservId +
                ", userByUserId=" + userByUserId +
                ", statuss=" + statuss +
                '}';
    }
}

