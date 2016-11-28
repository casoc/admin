package com.example.framework.util;

/**
 * @author casoc
 * @version $Id: AdminBaseException.java, v 0.1 2016/11/28 15:27 casoc Exp $
 */
public class AdminBaseException extends RuntimeException {

    /** 序列化id */
    private static final long serialVersionUID = 1298933134849397001L;

    /** 错误详细描述 */
    private String            detailMessage;

    /**
     * 含错误信息的构造函数,使用时需要特别注意此方法构造出来的异常结果码为默认的系统异常结果码
     *
     * @param errorMsg
     */
    public AdminBaseException(String errorMsg) {
        super(errorMsg);
    }

    /**
     * 含有异常栈和错误信息构造器,使用时需要特别注意此方法构造出来的异常结果码为默认的系统异常结果码
     *
     * @param errorMsg
     * @param t
     */
    public AdminBaseException(String errorMsg, Throwable t) {
        super(errorMsg, t);
    }

    public String getDetailMessage() {
        return detailMessage;
    }

    public void setDetailMessage(String detailMessage) {
        this.detailMessage = detailMessage;
    }

}
