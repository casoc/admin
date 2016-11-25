package com.example.framework.dao;

import com.example.framework.AdminApplicationTests;
import com.example.framework.dataobject.UserDO;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.assertNotNull;

/**
 * @author chenshiwei
 * @version $Id: UserDAOTest.java, v 0.1 2016/11/25 17:22 chenshiwei Exp $
 */
public class UserDAOTest extends AdminApplicationTests {

    @Resource
    private UserDAO userDAO;

    @Test
    public void findByName() throws Exception {
        UserDO admin = userDAO.findByName("admin");
        assertNotNull(admin);
    }

}