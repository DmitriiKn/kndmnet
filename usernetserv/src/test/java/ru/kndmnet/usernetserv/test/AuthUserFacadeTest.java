package ru.kndmnet.usernetserv.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;
import ru.kndmnet.usernetserv.persistanse.facade.EmailUserFacade;
import ru.kndmnet.usernetserv.persistanse.facade.UserFacade;
import ru.kndmnet.usernetserv.persistanse.repository.UserAuthDataRepository;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static ru.kndmnet.usernetserv.util.UserDataCreator.getTestUser;

@SpringBootTest
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)
public class AuthUserFacadeTest {

    @Autowired
    @Qualifier("emailUserFacade")
    private EmailUserFacade userFacade;
    @Autowired
    UserAuthDataRepository repository;

    @Test
    void testUniqueRegistration(){
        UserAuthData authData = getTestUser();
        UserAuthData userAuthData = userFacade.saveUserAuthData(authData);
        assertNotNull(userAuthData.getUserId());
    }

    @AfterEach
    void clearDB(){
        repository.deleteAll();
    }
}
