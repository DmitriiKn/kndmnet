package ru.kndmnet.usernetserv.persistanse.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.type.TrueFalseConverter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "user_auth_data")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserAuthData implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "email")
    private String email;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "password")
    private String password;

    @Column(name = "is_confirmed")
    @Convert(converter = TrueFalseConverter.class)
    private Boolean isConfirmed;

    @Column(name = "confirm_url")
    private String confirmationUrl;

    @Column(name = "confirm_url_exp_dttm")
    private LocalDateTime confirmationUrlExpirationDate;
}
