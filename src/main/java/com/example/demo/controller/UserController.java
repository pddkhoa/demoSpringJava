package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {


    @GetMapping("/")
    public String showUserList(Model model){
        List<User> listUsers = UserServiceStub.getAllUser();
        model.addAttribute("listUsers",listUsers);
        return "index.html";
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user)
    {
        return UserServiceStub.addUser(user);
    }

}