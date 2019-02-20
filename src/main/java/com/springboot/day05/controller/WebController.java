package com.springboot.day05.controller;

import com.springboot.day05.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class WebController {

    @RequestMapping("/saveUser")
    public void setUser(@Valid User user,BindingResult result){
        System.out.println("user: " + user);
        if (result.hasErrors()){
            List<ObjectError> allErrors = result.getAllErrors();
            for (ObjectError error : allErrors){
                System.out.println(error.getCode()+"-"+error.getDefaultMessage());
            }
        }
    }

    @RequestMapping(name = "/user",method = RequestMethod.POST)
    public User getUser(){
        User user = new User("hro", 22, "123456");
        return user;
    }

    @RequestMapping("/getUsers")
    public List<User> getUserList(){
        List userList = new ArrayList<User>();
        userList.add(new User("aa",21,"123"));
        userList.add(new User("bb",22,"123"));
        return userList;
    }
}
