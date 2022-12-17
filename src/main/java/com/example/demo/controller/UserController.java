package com.example.demo.controller;


import com.example.demo.model.User;
import com.example.demo.service.UserServiceStub;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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

    @GetMapping("/add")
    public String showNewForm(Model model){
        model.addAttribute("user",new User());
        model.addAttribute("pageTitle", "Add New User");
        return "add_user";
    }
    @PostMapping("/users/save")
    public String saveUser(User user, RedirectAttributes ra) {
        UserServiceStub.addUser(user);
        ra.addFlashAttribute("message", "The user has been saved successfully.");
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        UserServiceStub.deleteUser(id);
        ra.addFlashAttribute("message","The user ID " + id + " has been deleted.");
        return "redirect:/";
    }
}