package com.example.framework.dao;

import com.example.framework.dataobject.CustomFieldDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: CustonFieldDAO.java, v 0.1 2016/11/27 12:18 casoc Exp $
 */
public interface CustomFieldDAO extends JpaRepository<CustomFieldDO, Long> {
}
