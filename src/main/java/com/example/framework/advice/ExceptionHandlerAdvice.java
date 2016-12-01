package com.example.framework.advice;

import com.example.framework.helper.MessageHelper;
import com.example.framework.util.AdminBaseException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author casoc
 * @version $Id: ExceptionHandlerAdvice.java, v 0.1 2016/11/28 15:53 casoc Exp $
 */
@ControllerAdvice
public class ExceptionHandlerAdvice {

    @Resource
    private MessageHelper messageHelper;

    @ExceptionHandler(AdminBaseException.class)
    public ModelAndView handler(AdminBaseException exception) {
        ModelAndView error = new ModelAndView("error");
        error.addObject(messageHelper.getMessage(exception.getDetailMessage()));
        return error;
    }
}
