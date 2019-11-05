package com.laishishui.shirostudy.service;

import com.laishishui.shirostudy.model.User;

/**
 * Create by tachai on 2019-11-04 09:06
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface UserServcie {

    User findByUsername(String userName);
}
