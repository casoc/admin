package com.example.framework.dao;

import com.example.framework.dataobject.UserRoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author casoc
 * @version $Id: UserRoleDAO.java, v 0.1 2016/11/27 12:24 casoc Exp $
 */
public interface UserRoleDAO extends JpaRepository<UserRoleDO, Long> {
    List<UserRoleDO> findByUserId(Long userId);
}
