package com.example.framework.shiro;

import com.example.framework.dao.UserDAO;
import com.example.framework.dataobject.UserDO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.realm.Realm;

import javax.annotation.Resource;

/**
 * @author casoc
 * @version $Id: DatebaseRealm.java, v 0.1 2016/11/25 16:51 casoc Exp $
 */
public class UsernameRealm implements Realm {

    @Resource
    private UserDAO userDAO;

    @Override
    public String getName() {
        return "username realm";
    }

    @Override
    public boolean supports(AuthenticationToken authenticationToken) {
        return true;
    }

    @Override
    public AuthenticationInfo getAuthenticationInfo(AuthenticationToken authenticationToken)
                                                                                            throws AuthenticationException {
        String username = authenticationToken.getPrincipal().toString();
        String password = authenticationToken.getCredentials().toString();

        UserDO userDO = userDAO.findByName(username);

        if (userDO == null || !userDO.getPassword().equals(password))
            throw new UnknownAccountException();

        return new SimpleAuthenticationInfo(username, password, getName());
    }
}
