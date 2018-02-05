package com.sfl.controller;


import com.sfl.entity.CurrentUser;
import com.sfl.entity.Reserv;
import com.sfl.entity.Statuss;
import com.sfl.entity.TableCafe;
import com.sfl.service.ProductService;
import com.sfl.service.ReservService;
import com.sfl.service.TableCafeService;
import com.sfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by Karlen on 05.02.2018.
 */
@Controller
public class MainController {

    @Autowired
   private UserService userService;
    @Autowired
    private TableCafeService tableCafeService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ReservService reservService;


    @RequestMapping(value = "/")
    public String main() {
        return "redirect:/home";
    }

    @RequestMapping(value = "/home")
    public String toHomeJSP() {
        return "home";
    }

    @RequestMapping(value = "/manager")
    public String toManagerJSP(ModelMap modelMap) {
        modelMap.addAttribute("waiters", userService.getUsersListWereRoleIsWAITER());
        modelMap.addAttribute("tablesCafe", tableCafeService.getFreeTableCafeList());
        return "manager";
    }


    @RequestMapping(value = "/waiter")
    public String toWaiterJSP(ModelMap modelMap) {

        CurrentUser currentUser = (CurrentUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String name = currentUser.getUsername();


        modelMap.addAttribute("username", name);
        modelMap.addAttribute("tablesCafe", tableCafeService.getTableCafeByUserId(currentUser.getId()));
        modelMap.addAttribute("products", productService.getProductList());
        modelMap.addAttribute("freeTables", getUnReservedTableCafeList());
        return "waiter";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String printUser() {
        return "login";

    }
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/";
    }



    private List<TableCafe> getUnReservedTableCafeList() {

        ArrayList<TableCafe> tablesCafeList = null;
        List<TableCafe> tablesInCafe = tableCafeService.getTableCafeList();
        for (TableCafe tableCafe : tablesInCafe) {
            for (Reserv reserv : reservService.getReservListbyTableCafe(tableCafe)) {
                if (!reserv.getStatuss().equals(Statuss.CLOSED)) {
                    tablesCafeList.add(tableCafe);
                }


            }

        }
        return tablesCafeList;

    }


}
