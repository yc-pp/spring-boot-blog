package com.blog.base.util;

import java.io.Serializable;

public class Result<Object> implements Serializable {
    private static final long serialVersionUID = 1L;
    private String resultCode;
    private String message;
    private Object data;

    public Result() {
    }

    public Result(String resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
