package com.sfl.controller;

import com.sfl.entity.TableCafe;
import com.sfl.entity.User;
import com.sfl.service.ProductService;
import com.sfl.service.TableCafeService;
import com.sfl.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Karlen on 05.02.2018.
 */
@Controller
public class ManagerController {

    @Autowired
    private UserService userService;

    @Autowired
    private TableCafeService tableCafeService;

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/manager/user/add")
    public String addUser(@ModelAttribute("user") User user) {
        userService.addUser(user);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/table_cafe/add")
    public String addTableCafe(@ModelAttribute("table_cafe") TableCafe tableCafe, ModelMap modelMap) {
        modelMap.addAttribute("waiters", userService.getUsersListWereRoleIsWAITER());
        tableCafeService.addTableCafe(tableCafe);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/product/add")
    public String addProduct(@RequestParam("product") String product) {
        productService.addProduct(product);
        return "redirect:/manager";
    }

    @RequestMapping(value = "/manager/waiter/assign/table_cafe")
    public String assignCafeTableForWaiter(@RequestParam("username") String username,
                                           @RequestParam("name") String name) {
        User user = userService.getUserByUsername(username);
        TableCafe tableCafe = tableCafeService.getTableCafebynName(name);

        tableCafe.setUserByUserId(user);
        tableCafeService.addTableCafe(tableCafe);
        return "redirect:/manager";
    }

}
