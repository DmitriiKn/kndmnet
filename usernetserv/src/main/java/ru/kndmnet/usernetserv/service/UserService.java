package ru.kndmnet.usernetserv.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import ru.kndmnet.usernetserv.dto.registration.RegRequestDto;
import ru.kndmnet.usernetserv.dto.registration.RegResponseDto;
import ru.kndmnet.usernetserv.exception.ApiError;
import ru.kndmnet.usernetserv.exception.registration.AlreadyRegisteredException;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;
import ru.kndmnet.usernetserv.persistanse.repository.UserAuthDataRepository;

import static ru.kndmnet.usernetserv.conversion.RegistrationConverter.convertToAuthData;

@Component
@Slf4j
public class UserService {
    private static final String LOG_HEAD = "User service facade";

    private final UserAuthDataRepository authDataRepository;

    public UserService(UserAuthDataRepository authDataRepository) {
        this.authDataRepository = authDataRepository;
    }

    public RegResponseDto registerUserIfNotAlreadyExisted(RegRequestDto request) {
        log.info(LOG_HEAD.concat(" Registration start"));
        RegResponseDto response = new RegResponseDto();
        try {
            if (authDataRepository.existsByEmail(request.getEmail())){
                throw new AlreadyRegisteredException();
            } else {
                UserAuthData authData = convertToAuthData(request);
                authData = authDataRepository.save(authData);
                response.setUserId(authData.getUserId());
            }
            log.info(LOG_HEAD.concat(" Registration end"));
        } catch (AlreadyRegisteredException alreadyRegisteredException) {
            ApiError error = new ApiError("Already registered");
            response.setError(error);
            log.info(LOG_HEAD.concat(" Registration end"));
        } catch (Exception exception) {
            log.error(LOG_HEAD.concat(" Registration error: "), exception);
            ApiError error = new ApiError(exception.getMessage());
            response.setError(error);
        }
        return response;
    }
}
