package com.example.demo.service;

import com.example.demo.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceStub {
    private static Map<Integer, User> userMap = new HashMap<>();
    private List<User> list = new ArrayList<User>();

    private static int index = 2;
    static {
        User user1 = new User(1, "Khoa");
        User user2= new User(2,"Phuc");
        userMap.put(1,user1);
        userMap.put(2,user2);

    }
    public static List<User> getAllUser(){
        return new ArrayList<>(userMap.values());
    }
    public static User getUserDetail(int userid){
        return userMap.get(userid);
    }
    public static User addUser(User user)
    {
        index += 1;
        user.setId(index);
        userMap.put(index,user);
        return user;
    }
    public User save(User user) {
        User product = new User();
        product.setId(user.getId());
        product.setName(user.getName());
        list.add(product);
        return product;
    }
    public static User deleteUser(int userid)
    {
        return userMap.remove(userid);
    }
}
