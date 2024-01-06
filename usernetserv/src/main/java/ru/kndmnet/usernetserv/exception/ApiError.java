package ru.kndmnet.usernetserv.exception;

public class ApiError extends ErrorDto{
    public ApiError(String errorText) {
        super(errorText);
    }
}
