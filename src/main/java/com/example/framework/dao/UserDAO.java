package com.example.framework.dao;

import com.example.framework.dataobject.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author casoc
 * @version $Id: UserDAO.java, v 0.1 2016/11/25 16:53 casoc Exp $
 */
public interface UserDAO extends JpaRepository<UserDO, Long> {

    UserDO findByName(String name);

}
