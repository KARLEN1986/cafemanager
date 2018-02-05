package com.sfl.controller;



import com.sfl.entity.Order;
import com.sfl.entity.Reserv;
import com.sfl.entity.TableCafe;
import com.sfl.service.OrderService;
import com.sfl.service.ReservService;
import com.sfl.service.TableCafeService;
import com.sfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * Created by Karlen on 05.02.2018.
 */
@Controller
public class WaiterController {


    @Autowired
    private UserService userService;
    @Autowired
    private TableCafeService tableCafeService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private ReservService reservService;

    @RequestMapping(value = "/waiter/reserv/add")
    public String addReserv(@ModelAttribute("reserv") Reserv reserv,
                            @RequestParam("id") long id) {
        TableCafe tableCafe=tableCafeService.getTableCafeById(id);
        List<Reserv> reservList=reservService.getReservListbyTableCafe(tableCafe);
        reservList.add(reserv);
        return "redirect:/waiter";

    }


    @RequestMapping(value = "/waiter/order/add")
    public String addOrderedProduct(@ModelAttribute("order") Order order) {
        orderService.addOrder(order);


        return "redirect:/waiter";

    }



}
