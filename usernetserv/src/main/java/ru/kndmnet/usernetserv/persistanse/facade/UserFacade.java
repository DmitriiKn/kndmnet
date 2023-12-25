package ru.kndmnet.usernetserv.persistanse.facade;

import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;

public interface UserFacade {
    public UserAuthData saveUserAuthData(UserAuthData authData);
}
