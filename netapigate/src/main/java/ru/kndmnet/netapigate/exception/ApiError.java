package ru.kndmnet.netapigate.exception;

import lombok.*;

@ToString
@NoArgsConstructor
@Getter
@Setter
public class ApiError extends ErrorDto{
    public ApiError(String errorText) {
        super(errorText);
    }
}
