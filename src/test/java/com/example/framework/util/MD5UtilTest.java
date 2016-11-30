package com.example.framework.util;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author casoc
 * @version $Id: MD5UtilTest.java, v 0.1 2016/11/30 17:42 casoc Exp $
 */
public class MD5UtilTest {
    @Test
    public void textToMD5L32() throws Exception {
        String password = MD5Util.textToMD5L32("admin");
        assertThat(password, is("21232f297a57a5a743894a0e4a801fc3"));
    }

}