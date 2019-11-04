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
public class Role {

    private Integer rid;

    private String name;

    private Set<Permission> permissions= new HashSet<>();

    private Set<User> users = new HashSet<>();
}
