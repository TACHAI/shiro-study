package com.laishishui.shirostudy.model;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

/**
 * Create by tachai on 2019-11-04 09:00
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
@Data
public class User {

    private Integer uid;

    private String username;

    private String password;

    private Set<Role> roles = new HashSet<>();
}
