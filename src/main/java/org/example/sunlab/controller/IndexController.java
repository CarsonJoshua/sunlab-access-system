package org.example.sunlab.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
public class IndexController {

    @GetMapping("/")
    public String homePage(Model model){
        return "home";
    }

    @GetMapping("/admin")
    public String adminPage(Model model){
        return "admin";
    }

    @GetMapping("/admin/log")
    public String logPage(Model model){
        return "log";
    }

    @GetMapping("/admin/users")
    public String usersPage(Model model){
        return "users";
    }
}
