package com.example.framework.dao;

import com.example.framework.dataobject.RolePrivilegeDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: RolePrivilegeDAO.java, v 0.1 2016/11/27 12:23 casoc Exp $
 */
public interface RolePrivilegeDAO extends JpaRepository<RolePrivilegeDO, Long> {
}
