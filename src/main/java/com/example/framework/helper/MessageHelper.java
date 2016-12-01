package com.example.framework.helper;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author casoc
 * @version $Id: MessageHelper.java, v 0.1 2016/12/1 16:07 casoc Exp $
 */
@Component
public class MessageHelper {

    @Resource
    private MessageSource messageSource;

    public String getMessage(String code) {
        return messageSource.getMessage(code, null, LocaleContextHolder.getLocale());
    }

}
