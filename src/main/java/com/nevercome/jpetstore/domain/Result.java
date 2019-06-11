package com.nevercome.jpetstore.domain;

import lombok.Data;

@Data
public class Result {

    private String result;
    private String message;
    private Object obj;
    public static final String RESULT_SUCCESS = "success";
    public static final String RESULT_ERROR = "error";
    public static final String RESULT_FAIL = "fail";

    public Result() {
        this.result = RESULT_SUCCESS;
        this.message = null;
        this.obj = null;
    }

    public Result(String message) {
        this.result = RESULT_SUCCESS;
        this.message = message;
        this.obj = null;
    }

    public Result(Object obj) {
        this.result = RESULT_SUCCESS;
        this.message = null;
        this.obj = obj;
    }

    public Result(String result, String message) {
        this.result = result;
        this.message = message;
        this.obj = null;
    }

    public Result(String result, Object obj) {
        this.result = result;
        this.message = null;
        this.obj = obj;
    }
}
