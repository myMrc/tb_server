package com.gx.common;

public class Result<T> {

    private T data;
    private Integer code;
    private String msg;

    public Result() {
    }

    public Result(Integer code, T data) {
        this.data = data;
        this.code = code;
    }

    public Result(Integer code, T data, String msg) {
        this.data = data;
        this.code = code;
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
