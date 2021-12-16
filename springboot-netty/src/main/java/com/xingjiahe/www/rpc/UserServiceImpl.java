package com.xingjiahe.www.rpc;

public class UserServiceImpl implements IUserService {
    @Override
    public User findById(Long id) {
        User user = new User();
        user.setName("hejiaxing");
        user.setAge(123);
        return user;
    }
}
