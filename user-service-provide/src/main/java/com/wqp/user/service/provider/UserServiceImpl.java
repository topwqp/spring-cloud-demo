package com.wqp.user.service.provider;

import api.UserService;
import com.google.common.collect.Lists;
import domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description 服务实现
 * @Author Wang QiuPeng
 * Date 19/4/7 17:44
 **/
@Service
public class UserServiceImpl implements UserService {

    private Map<Integer,User> userMap = new ConcurrentHashMap(16);

    @Override
    public boolean saveUser(User user) {
        return userMap.put(user.getUserId(),user) == null;
    }

    @Override
    public List<User> queryAllUser() {
        List<User>  list =new ArrayList<>(userMap.values());
        return list;
    }
}
