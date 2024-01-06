package ru.kndmnet.usernetserv.persistanse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kndmnet.usernetserv.persistanse.entity.UserAuthData;

import java.util.UUID;

@Repository
public interface UserAuthDataRepository extends JpaRepository<UserAuthData, UUID> {
    boolean existsByEmail(String email);
}
