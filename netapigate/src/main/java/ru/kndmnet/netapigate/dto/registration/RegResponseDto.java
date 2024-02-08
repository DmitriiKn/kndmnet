package ru.kndmnet.netapigate.dto.registration;

import lombok.*;
import ru.kndmnet.netapigate.exception.ApiError;

import java.util.UUID;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegResponseDto {
    private UUID userId;
    private ApiError error;
}
