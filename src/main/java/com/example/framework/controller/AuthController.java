package com.example.framework.controller;

import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author casoc
 * @version $Id: AuthController.java, v 0.1 2016/11/28 11:17 casoc Exp $
 */
@Controller
@RequiresGuest
public class AuthController {

    @RequestMapping(name = "/login")
    public String loginPage() {
        return "login";
    }

}
