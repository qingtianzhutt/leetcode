package com.example.utils;

public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    /**
     * 错误状态码
     */
    protected Integer errorCode;
    /**
     * 错误提示
     */
    protected String errorMsg;

    public BusinessException(){

    }

    public BusinessException(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
