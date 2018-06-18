package com.otmoc.ubain.auth.realm;

import com.otmoc.ubain.model.LoginUser;
import com.otmoc.ubain.service.AuthService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginUserRealm extends AuthorizingRealm {

    @Autowired
    private AuthService authService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addRole("admin");
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        LoginUser user = authService.getUser(token.getUsername(), String.valueOf(token.getPassword()));
        if(user == null) {
            return null;
        }
        return new SimpleAuthenticationInfo(authenticationToken.getPrincipal(), token.getCredentials(), this.getName());
    }
}
