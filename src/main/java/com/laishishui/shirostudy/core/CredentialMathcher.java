package com.laishishui.shirostudy.core;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.SimpleCredentialsMatcher;

/**
 * Create by tachai on 2019-11-04 21:18
 * gitHub https://github.com/TACHAI
 * Email tc1206966083@gmail.com
 */
public class CredentialMathcher extends SimpleCredentialsMatcher {

    // shiro 密码校验规则重写
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info){
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;
        String  password = new String(usernamePasswordToken.getPassword());
        String dbPassword = (String) info.getCredentials();
        return this.equals(password,dbPassword);
    }
}
