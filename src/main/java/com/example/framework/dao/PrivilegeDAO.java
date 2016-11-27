package com.example.framework.dao;

import com.example.framework.dataobject.PrivilegeDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: PrivilegeDAO.java, v 0.1 2016/11/27 12:21 casoc Exp $
 */
public interface PrivilegeDAO extends JpaRepository<PrivilegeDO, Long> {
}
