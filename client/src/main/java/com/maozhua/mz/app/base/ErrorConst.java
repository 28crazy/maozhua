package com.maozhua.mz.app.base;

public enum ErrorConst {
    SUCCESS(200, "success"),
    ERROR(500, "error");

    private int code;
    private String message;

    ErrorConst(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
