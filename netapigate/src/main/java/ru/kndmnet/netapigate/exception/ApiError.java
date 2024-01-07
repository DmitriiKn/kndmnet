package ru.kndmnet.netapigate.exception;

public class ApiError extends ErrorDto{
    public ApiError(String errorText) {
        super(errorText);
    }
}
