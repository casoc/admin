package com.example.framework.controller;

import com.example.framework.helper.MessageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author casoc
 * @version $Id: AuthController.java, v 0.1 2016/11/28 11:17 casoc Exp $
 */
@Controller
@RequiresGuest
public class AuthController {

    @Resource
    private MessageHelper messageHelper;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Map<String, List<String>> map, String username, String password) {
        List<String> errors = new ArrayList();
        try {
            UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
            SecurityUtils.getSubject().login(usernamePasswordToken);
        } catch (UnknownAccountException e) {
            errors.add(messageHelper.getMessage("exception.unknownUser"));
        } catch (IncorrectCredentialsException e) {
            errors.add(messageHelper.getMessage("exception.incorrectCredentials"));
        } catch (Exception e) {
            errors.add(messageHelper.getMessage("exception.unknown"));
        }

        map.put("errors", errors);

        if (errors.isEmpty()) {
            return "redirect:/";
        } else {
            return "redirect:/login";
        }
    }

}
