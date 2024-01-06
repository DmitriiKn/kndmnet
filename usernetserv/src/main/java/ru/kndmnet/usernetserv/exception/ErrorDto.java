package ru.kndmnet.usernetserv.exception;

public abstract class ErrorDto {

    public ErrorDto(String errorText) {
        this.errorText = errorText;
    }

    private String errorText;

    public String getErrorText() {
        return errorText;
    }

    public void setErrorText(String errorText) {
        this.errorText = errorText;
    }
}
