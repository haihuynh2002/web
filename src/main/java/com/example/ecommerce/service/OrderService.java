/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.ecommerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ecommerce.model.Order;
import com.example.ecommerce.repository.OrderProductRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.PaymentRepository;
import com.example.ecommerce.repository.UserRepository;

import java.util.List;

/**
 *
 * @author infoh
 */
@Service
@Transactional
public class OrderService {
    
    @Autowired
    UserService us;
    
    @Autowired
    ProductService bs;
    
    @Autowired
    OrderProductRepository opr;
    
    @Autowired
    OrderRepository or;
    
    @Autowired
    PaymentRepository pr;
    
    @Autowired
    UserRepository ur;

    public List<Order> findAll() {
        return or.findAll();
    }
    
}
