package ru.kndmnet.usernetserv.service;

import org.springframework.stereotype.Component;
import ru.kndmnet.usernetserv.dto.registration.RegRequestDto;
import ru.kndmnet.usernetserv.dto.registration.RegResponseDto;

@Component
public class UserService {
    public RegResponseDto registerUserIfNotAlreadyExisted(RegRequestDto request) {
        return new RegResponseDto();
    }
}
