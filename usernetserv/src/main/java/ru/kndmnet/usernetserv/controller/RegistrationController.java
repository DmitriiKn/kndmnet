package ru.kndmnet.usernetserv.controller;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kndmnet.usernetserv.dto.registration.RegRequestDto;
import ru.kndmnet.usernetserv.dto.registration.RegResponseDto;
import ru.kndmnet.usernetserv.service.UserService;

@RestController
@RequestMapping("api/v1/user/registration")
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(produces = "application/json")
    public ResponseEntity<?> register(@RequestBody @Valid RegRequestDto request){
        try {
            RegResponseDto registrationResult = userService.registerUserIfNotAlreadyExisted(request);
            return new ResponseEntity(registrationResult, HttpStatus.OK);
        } catch (Throwable exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
