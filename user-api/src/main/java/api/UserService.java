package api;

import domain.User;

import java.util.List;

/**
 * @Description 用户服务
 * @Author Wang QiuPeng
 * Date 19/4/7 17:39
 **/
public interface UserService {

    /**
     * 保存用户信息
     * @param user
     * @return
     */
    boolean saveUser(User user);


    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();
}
