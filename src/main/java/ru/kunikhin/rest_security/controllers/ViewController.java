package ru.kunikhin.rest_security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    @GetMapping("/admin")
    public String currentAdmin() {
        return "admin/index";
    }

    @GetMapping("/user")
    public String currentUser() {
        return "user/userPage";
    }

    @GetMapping(value = "/")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = "/logout")
    public String getLogoutPage() {
        return "login";
    }

}