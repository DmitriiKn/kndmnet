package ru.kndmnet.usernetserv.dto.registration;

import lombok.ToString;
import ru.kndmnet.usernetserv.exception.ApiError;

import java.util.UUID;

@ToString
public class RegResponseDto {
    private UUID userId;
    private ApiError error;

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    public ApiError getError() {
        return error;
    }

    public void setError(ApiError error) {
        this.error = error;
    }
}
