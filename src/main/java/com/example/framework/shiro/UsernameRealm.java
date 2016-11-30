package com.example.framework.shiro;

import com.example.framework.dao.PrivilegeDAO;
import com.example.framework.dao.RoleDAO;
import com.example.framework.dao.RolePrivilegeDAO;
import com.example.framework.dao.UserDAO;
import com.example.framework.dao.UserRoleDAO;
import com.example.framework.dataobject.PrivilegeDO;
import com.example.framework.dataobject.RoleDO;
import com.example.framework.dataobject.RolePrivilegeDO;
import com.example.framework.dataobject.UserDO;
import com.example.framework.dataobject.UserRoleDO;
import com.example.framework.util.MD5Util;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
        String username = (String) authenticationToken.getCredentials();
        String password = (String) authenticationToken.getPrincipal();

        UserDO userDO = userDAO.findByName(username);
        if (userDO == null || isPasswordCorrect(userDO, MD5Util.textToMD5L32(password)))
            throw new UnknownAccountException();

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(userDO,
            password, "Username Realm");
        return simpleAuthenticationInfo;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        UserDO user = (UserDO) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();

        Set<String> roleNames = new HashSet();
        Set<String> privilegeNames = new HashSet();

        List<UserRoleDO> userRoleDOs = userRoleDAO.findByUserId(user.getId());
        if (!userRoleDOs.isEmpty()) {
            List<Long> roleIds = userRoleDOs.stream().map(userRole -> userRole.getUserId())
                .collect(Collectors.toList());
            List<RoleDO> roleDOs = roleDAO.findByIdIn(roleIds);
            roleDOs.forEach(roleDO -> roleNames.add(roleDO.getName()));

            List<RolePrivilegeDO> rolePrivilegeDOs = rolePrivilegeDAO.findByRoleIdIn(roleIds);
            List<Long> privilegeIds = rolePrivilegeDOs.stream()
                .map(rolePrivilegeDO -> rolePrivilegeDO.getId()).collect(Collectors.toList());
            List<PrivilegeDO> privilegeDOs = privilegeDAO.findByIdIn(privilegeIds);
            privilegeDOs.forEach(privilegeDO -> privilegeNames.add(privilegeDO.getName()));
        }

        simpleAuthorizationInfo.setRoles(roleNames);
        simpleAuthorizationInfo.setStringPermissions(privilegeNames);

        return simpleAuthorizationInfo;
    }

    public boolean isPasswordCorrect(UserDO userDO, String password) {
        return userDO.getPassword().equals(MD5Util.textToMD5L32(password));
    }
}
