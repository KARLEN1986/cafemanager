package com.sfl.repsitory;


import com.sfl.entity.Order;
import com.sfl.entity.Reserv;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;
/**
 * Created by Karlen on 05.02.2018.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {


List<Order> findOrdersByReservSet(Set<Reserv> reservs);
}
