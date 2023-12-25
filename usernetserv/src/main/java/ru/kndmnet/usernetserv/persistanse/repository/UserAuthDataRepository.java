package ru.kndmnet.usernetserv.persistanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;

import java.util.UUID;

public interface UserAuthDataRepository extends JpaRepository<UserAuthData, UUID> {
}
