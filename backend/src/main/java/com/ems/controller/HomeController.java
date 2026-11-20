package com.ems.controller;

import com.ems.routes.ApiRoutes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping(ApiRoutes.HOME)
    public String home() {
        return "Welcome to Employee Management System API!";
    }

    @GetMapping(ApiRoutes.HEALTH)
    public String healthCheck() {
        return "Employee Management System API is Running!";
    }
}
