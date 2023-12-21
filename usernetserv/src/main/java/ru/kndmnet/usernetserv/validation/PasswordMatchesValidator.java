package ru.kndmnet.usernetserv.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import ru.kndmnet.usernetserv.dto.registration.RegRequestDto;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(PasswordMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        RegRequestDto user = (RegRequestDto) obj;
        return user.getPassword().equals(user.getMatchingPassword());
    }
}
