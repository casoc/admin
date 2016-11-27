package com.example.framework.dao;

import com.example.framework.dataobject.NavigationDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: NavigationDAO.java, v 0.1 2016/11/27 12:21 casoc Exp $
 */
public interface NavigationDAO extends JpaRepository<NavigationDO, Long> {
}
