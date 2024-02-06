package ru.kndmnet.usernetserv.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kndmnet.usernetserv.exception.registration.AlreadyRegisteredException;
import ru.kndmnet.usernetserv.persistanse.repository.UserAuthDataRepository;
import ru.kndmnet.usernetserv.service.UserService;

import static org.junit.jupiter.api.Assertions.*;
import static ru.kndmnet.usernetserv.util.UserDataCreator.getTestRegRequest;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class UserServiceTest {

    @Autowired private UserService userService;
    @Autowired private UserAuthDataRepository repository;


    @Test
    void testWhenUniqueUsersRegistering(){
        final int count = 3;
        for (int i = 0; i < count; i++) {
            var request = getTestRegRequest(true);
            try {
                userService.registerUserIfNotAlreadyExisted(request);
            } catch (Exception ignore){}
        }
        assertEquals(count, repository.findAll().size());
    }

    @Test
    void testWhenTwoSameUserRegistering(){
            var request = getTestRegRequest();
            userService.registerUserIfNotAlreadyExisted(request);
            assertNotNull(userService.registerUserIfNotAlreadyExisted(request).getError());
    }
}
