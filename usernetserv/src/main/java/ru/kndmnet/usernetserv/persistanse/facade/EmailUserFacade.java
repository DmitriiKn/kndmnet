package ru.kndmnet.usernetserv.persistanse.facade;

import org.springframework.stereotype.Component;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;
import ru.kndmnet.usernetserv.persistanse.repository.UserAuthDataRepository;

@Component("emailUserFacade")
public class EmailUserFacade implements UserFacade{

    private final UserAuthDataRepository authDataRepository;

    public EmailUserFacade(UserAuthDataRepository authDataRepository) {
        this.authDataRepository = authDataRepository;
    }

    @Override
    public UserAuthData saveUserAuthData(UserAuthData authData) {
        return authDataRepository.save(authData);
    }
}
