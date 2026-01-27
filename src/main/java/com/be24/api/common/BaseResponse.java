package com.be24.api.common;

public class BaseResponse<T> {
    private Boolean success;
    private Integer code;
    private String status;
    private T result;

    public BaseResponse(Boolean success, Integer code, String status, T result) {
        this.success = success;
        this.code = code;
        this.status = status;
        this.result = result;
    }

    public static <T> BaseResponse success(T result) {
        return new BaseResponse(true, 200, "OK", result);
    }

    public static <T> BaseResponse fail(T result) {
        return new BaseResponse(false, 300, "Error", result);
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
