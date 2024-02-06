package ru.kndmnet.usernetserv.util;

import ru.kndmnet.usernetserv.dto.registration.RegRequestDto;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;

import java.util.UUID;

public class UserDataCreator {
    public static UserAuthData getTestUser(){
        return UserAuthData.builder()
                .userName("test")
                .email("ya@ya.ru")
                .password("abracadabra")
                .build();
    }

    public static RegRequestDto getTestRegRequest(boolean unique){
        var user = getTestUser();
        var dto = new RegRequestDto();
        dto.setEmail((unique ? UUID.randomUUID().toString() : "") + user.getEmail());
        dto.setPassword(user.getPassword());
        dto.setMatchingPassword(user.getPassword());
        dto.setFirstName(user.getUserName());
        return dto;
    }

    public static RegRequestDto getTestRegRequest(){
        return getTestRegRequest(false);
    }
}
