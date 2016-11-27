package com.example.framework.dao;

import com.example.framework.dataobject.UserRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: UserRoleDAO.java, v 0.1 2016/11/27 12:24 casoc Exp $
 */
public interface UserRoleDAO extends JpaRepository<UserRoleDO, Long> {
}
