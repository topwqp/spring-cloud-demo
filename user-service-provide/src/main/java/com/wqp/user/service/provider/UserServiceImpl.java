package com.wqp.user.service.provider;

import api.UserService;
import com.google.common.collect.Lists;
import domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 服务实现
 * @Author Wang QiuPeng
 * Date 19/4/7 17:44
 **/
@Service
public class UserServiceImpl implements UserService {

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public List<User> findAll() {
        User tom = new User.Builder().userId(1).username("Tom").build();
        User cat = new User.Builder().userId(2).username("cat").build();
        User jeffy = new User.Builder().userId(3).username("jeffy").build();
        List<User>  list = Lists.newArrayList(tom,cat,jeffy);
        return list;
    }
}
