package ru.kndmnet.usernetserv.conversion;

import ru.kndmnet.usernetserv.dto.registration.RegRequestDto;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;

public class RegistrationConverter {
    public static UserAuthData convertToAuthData(RegRequestDto regRequest){

        return UserAuthData.builder()
                .email(regRequest.getEmail())
                .password(encodePassword(regRequest.getPassword()))
                .userName(regRequest.getFirstName() + ' ' + regRequest.getLastName())
                .isConfirmed(false)
                .build();
    }

    private static String encodePassword(String origPass){
        //todo  make encoding
        return origPass;
    }
}
