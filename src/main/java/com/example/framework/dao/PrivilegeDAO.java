package com.example.framework.dao;

import com.example.framework.dataobject.PrivilegeDO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author casoc
 * @version $Id: PrivilegeDAO.java, v 0.1 2016/11/27 12:21 casoc Exp $
 */
public interface PrivilegeDAO extends JpaRepository<PrivilegeDO, Long> {
    List<PrivilegeDO> findByIdIn(List<Long> privilegeIds);
}
