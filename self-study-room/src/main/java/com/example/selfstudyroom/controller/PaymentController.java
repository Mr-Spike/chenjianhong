package com.example.selfstudyroom.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @PostMapping("/start")
    public String startPayment() {
        return "Payment integration placeholder";
    }
}
