package ru.kndmnet.netapigate.web.registration;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.kndmnet.netapigate.dto.registration.RegResponseDto;

@Component
public class RegistrationHandler {
    public Mono<ServerResponse> register(ServerRequest request){
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(new RegResponseDto()));
    }
}
