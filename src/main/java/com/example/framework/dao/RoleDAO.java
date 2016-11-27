package com.example.framework.dao;

import com.example.framework.dataobject.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: RoleDAO.java, v 0.1 2016/11/27 12:22 casoc Exp $
 */
public interface RoleDAO extends JpaRepository<RoleDO, Long> {
}
