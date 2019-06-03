package com.wqp.shardingjdbcdemo.service.impl;

import com.wqp.shardingjdbcdemo.common.util.IDGenerateUtil;
import com.wqp.shardingjdbcdemo.dao.UserMapper;
import com.wqp.shardingjdbcdemo.entity.User;
import com.wqp.shardingjdbcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: user service implement
 * @Author Wang QiuPeng
 * @Date 2019-06-03 14:40
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUser(Integer userId) {
        return userMapper.getUser(userId);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public int addUser(User user) {
        user.setUserId(IDGenerateUtil.getUserId());
        return userMapper.addUser(user);
    }

    @Override
    public int batchAddUser(List<User> users) {
        for (User user : users) {
            user.setUserId(IDGenerateUtil.getUserId());
        }
        return userMapper.batchAddUser(users);
    }
}
