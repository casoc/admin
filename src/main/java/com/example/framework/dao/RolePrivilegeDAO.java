package com.example.framework.dao;

import com.example.framework.dataobject.RolePrivilegeDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author casoc
 * @version $Id: RolePrivilegeDAO.java, v 0.1 2016/11/27 12:23 casoc Exp $
 */
public interface RolePrivilegeDAO extends JpaRepository<RolePrivilegeDO, Long> {
    List<RolePrivilegeDO> findByRoleIdIn(List<Long> roleIds);
}
