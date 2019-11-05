package com.laishishui.shirostudy.core;

import com.laishishui.shirostudy.model.Permission;
import com.laishishui.shirostudy.model.Role;
import com.laishishui.shirostudy.model.User;
import com.laishishui.shirostudy.service.UserServcie;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Create by tachai on 2019-11-04 20:28
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class AuthRealm extends AuthorizingRealm {

    @Autowired
    private UserServcie userServcie;

    // 授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user = (User) principalCollection.fromRealm(this.getClass().getName()).iterator().next();
        List<String> permissionList = new ArrayList<>();
        List<String> roleNameList = new ArrayList<>();
        Set<Role> roleSet = user.getRoles();
        if(!CollectionUtils.isEmpty(roleSet)){
            for(Role role : roleSet){
                roleNameList.add(role.getName());
                Set<Permission> permissionSet = role.getPermissions();
                if(!CollectionUtils.isEmpty(permissionSet)){
                    for(Permission permission: permissionSet){
                        permissionList.add(permission.getName());
                    }
                }
            }
        }
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionList);
        info.addRoles(roleNameList);
        return info;
    }
    // 认证登录
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();
        User user = userServcie.findByUsername(username);

        return new SimpleAuthenticationInfo(user,user.getPassword(),this.getClass().getName());
    }
}
