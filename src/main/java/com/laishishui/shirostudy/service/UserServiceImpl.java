package com.laishishui.shirostudy.service;

import com.laishishui.shirostudy.mapper.UserMapper;
import com.laishishui.shirostudy.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Create by tachai on 2019-11-04 09:09
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Service
public class UserServiceImpl implements UserServcie {

    @Resource
    private UserMapper userMapper;

    @Override
    public User findByUsername(String userName) {

        return userMapper.findByUsername(userName);
    }
}
