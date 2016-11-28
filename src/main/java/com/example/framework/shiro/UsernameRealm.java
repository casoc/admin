package com.example.framework.shiro;

import com.example.framework.dao.PrivilegeDAO;
import com.example.framework.dao.RoleDAO;
import com.example.framework.dao.RolePrivilegeDAO;
import com.example.framework.dao.UserDAO;
import com.example.framework.dao.UserRoleDAO;
import com.example.framework.dataobject.UserDO;
import com.example.framework.util.MD5Util;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

/**
 * @author casoc
 * @version $Id: UsernameRealm.java, v 0.1 2016/11/25 16:51 casoc Exp $
 */
public class UsernameRealm extends AuthorizingRealm {

    @Resource
    private UserDAO          userDAO;

    @Resource
    private RoleDAO          roleDAO;

    @Resource
    private PrivilegeDAO     privilegeDAO;

    @Resource
    private UserRoleDAO      userRoleDAO;

    @Resource
    private RolePrivilegeDAO rolePrivilegeDAO;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
                                                                                                 throws AuthenticationException {
        return null;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    public boolean isPasswordCorrect(UserDO userDO, String password) {
        return userDO.getPassword().equals(MD5Util.textToMD5L32(password));
    }
}
