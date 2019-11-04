package com.laishishui.shirostudy.mapper;

import com.laishishui.shirostudy.model.User;
import org.apache.ibatis.annotations.Param;

/**
 * Create by tachai on 2019-11-04 09:05
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public interface UserMapper {

    User findByUsername(@Param("username")String username);
}
