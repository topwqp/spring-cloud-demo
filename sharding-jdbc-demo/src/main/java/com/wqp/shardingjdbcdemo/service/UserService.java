package com.wqp.shardingjdbcdemo.service;

import com.wqp.shardingjdbcdemo.entity.User;

import java.util.List;

/**
 * @Description: user service
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:34
 */
public interface UserService {

    User getUser(Integer userId);

    List<User> getUsers();

    int addUser(User user);

    int batchAddUser(List<User> users);
}
