package com.example.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.ecommerce.dto.OrderDto;
import com.example.ecommerce.model.Payment;
import com.example.ecommerce.model.User;
import com.example.ecommerce.service.OrderService;
import com.example.ecommerce.service.PaymentService;
import com.example.ecommerce.service.UserService;

@Controller
public class HomeController {

    @Autowired
    UserService us;

    @Autowired
    PaymentService ps;

    @Autowired
    OrderService os;

    @GetMapping("/")
    public String index() {
        return "index.html";
    }

    @GetMapping("/account")
    public String account() {
        return "account";
    }

    @GetMapping("/order")
    public String order() {
        return "order";
    }

    @GetMapping("/cart")
    public String cart() {
        return "cart.html";
    }

    @GetMapping("/shop")
    public String shop() {
        return "shop";
    }

    @GetMapping("/checkout")
    public String checkout(Model model, Authentication auth) {
        User user = us.findByAuthentication(auth);
        OrderDto orderDto = new OrderDto();
        List<Payment> payments = ps.findByUserId(user.getId());
        model.addAttribute("order", orderDto);
        model.addAttribute("payments", payments);
        return "checkout";
    }

    @PostMapping("/checkout")
    public String order(@ModelAttribute("order") OrderDto orderDto, Authentication auth) {
        User user = us.findByAuthentication(auth);
        os.create(orderDto, user);
        return "index";
    }

    @GetMapping("/profile")
    public String profile(Model model, Authentication auth) {
        User user = us.findByAuthentication(auth);
        model.addAttribute("user", user);
        return "profile";
    }
}
