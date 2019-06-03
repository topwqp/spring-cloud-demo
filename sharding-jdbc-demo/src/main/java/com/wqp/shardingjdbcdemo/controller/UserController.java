package com.wqp.shardingjdbcdemo.controller;

import com.wqp.shardingjdbcdemo.entity.User;
import com.wqp.shardingjdbcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description: user controller
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:54
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public User getUser(Integer userId) {
        return userService.getUser(userId);
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @RequestMapping(value = "/batchAddUser", method = RequestMethod.POST)
    public int batchAddUser(@RequestBody List<User> users) {
        return userService.batchAddUser(users);
    }


}
