package com.maozhua.mz.app.base;

import lombok.Data;

@Data
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> BaseResponse<T> success(T data) {
        return of(ErrorConst.SUCCESS, data);
    }

    public static <T> BaseResponse<T> success(T data, ErrorConst errorConst) {
        return of(errorConst, data);
    }

    public static <T> BaseResponse<T> error(ErrorConst errorConst) {
        return of(errorConst, null);
    }

    private static <T> BaseResponse<T> of(ErrorConst errorConst, T data) {
        return new BaseResponse<>(errorConst.getCode(), errorConst.getMessage(), data);
    }

    private BaseResponse(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
