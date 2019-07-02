package com.blog.base.util;

import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 响应结果生成工具
 *
 */
public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "交易成功";
    private static final String DEFAULT_FAIL_MESSAGE = "交易失败";
    private static final String RESULT_CODE_SUCCESS = "000000";
    private static final String RESULT_CODE_SERVER_ERROR = "010000";

    public static Result genSuccessResult() {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        return result;
    }

    public static Result genSuccessResult(Object data) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SUCCESS);
        result.setMessage(DEFAULT_SUCCESS_MESSAGE);
        result.setData(data);
        return result;
    }

    public static Result genFailResult(String message) {
        Result result = new Result();
        result.setResultCode(RESULT_CODE_SERVER_ERROR);
        if (StringUtils.isEmpty(message)) {
            result.setMessage(DEFAULT_FAIL_MESSAGE);
        } else {
            result.setMessage(message);
        }
        return result;
    }

    public static Result genErrorResult(String code, String message) {
        Result result = new Result();
        result.setResultCode(code);
        result.setMessage(message);
        return result;
    }
}
