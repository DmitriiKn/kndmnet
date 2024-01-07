package ru.kndmnet.netapigate.web.registration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration(proxyBeanMethods = false)
public class RegistrationRouter {

    @Bean
    public RouterFunction<ServerResponse> registrationRoute(RegistrationHandler handler){
        return RouterFunctions.route(POST("/api/v1/gate/user/registration")
                .and(accept(MediaType.APPLICATION_JSON)), handler::register);
    }

}
