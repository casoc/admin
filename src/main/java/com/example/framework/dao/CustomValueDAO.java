package com.example.framework.dao;

import com.example.framework.dataobject.CustomValueDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: CustomValueDAO.java, v 0.1 2016/11/27 12:20 casoc Exp $
 */
public interface CustomValueDAO extends JpaRepository<CustomValueDO, Long> {
}
