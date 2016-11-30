package com.example.framework.dao;

import com.example.framework.dataobject.RoleDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author casoc
 * @version $Id: RoleDAO.java, v 0.1 2016/11/27 12:22 casoc Exp $
 */
public interface RoleDAO extends JpaRepository<RoleDO, Long> {
    List<RoleDO> findByIdIn(List<Long> roleIds);
}
