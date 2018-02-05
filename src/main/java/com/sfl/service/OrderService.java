package com.sfl.service;

import com.sfl.entity.Order;
import com.sfl.repsitory.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by Karlen on 05.02.2018.
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.save(order);
    }
}
