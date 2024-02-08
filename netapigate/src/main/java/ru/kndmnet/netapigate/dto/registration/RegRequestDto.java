package ru.kndmnet.netapigate.dto.registration;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RegRequestDto {
    private String firstName;
    private String lastName;
    private String password;
    private String matchingPassword;
    private String email;

}