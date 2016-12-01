package com.example.framework.controller;

/**
 * @author casoc
 * @version $Id: HomeController.java, v 0.1 2016/12/1 16:18 casoc Exp $
 */
//@Controller
//@RequiresAuthentication
public class HomeController {

    //    @RequestMapping(name = "")
    public String index() {
        return "index";
    }
}
