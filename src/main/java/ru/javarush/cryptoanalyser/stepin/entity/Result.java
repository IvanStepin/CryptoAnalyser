package ru.javarush.cryptoanalyser.stepin.entity;

public class Result {

    private final ResultCodeEnum resultCode;
    private final String message;

    public Result(ResultCodeEnum resultCode, String message) {
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "resultCode=" + resultCode +
                ", message='" + message + '\'' +
                '}';
    }
}
