package ru.kndmnet.netapigate.web.registration;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import ru.kndmnet.netapigate.dto.registration.RegRequestDto;
import ru.kndmnet.netapigate.dto.registration.RegResponseDto;
import ru.kndmnet.netapigate.exception.ApiError;

@Component
@Slf4j
public class RegistrationHandler {

    private final RegistrationServiceAdapter adapter;

    public RegistrationHandler(RegistrationServiceAdapter adapter) {
        this.adapter = adapter;
    }

    public Mono<ServerResponse> register(ServerRequest request){
        try {
            return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                    .body(BodyInserters.fromValue(
                            adapter.callRegistrationService(request.bodyToMono(RegRequestDto.class)
                                    .block())
                    ));
        } catch (Exception exception) {
            log.error("Registration request if fall with error: ", exception);
            return handleError(exception);
        }
    }

    private Mono<ServerResponse> handleError(Exception exception) {
        var response = new RegResponseDto();
        response.setError(new ApiError(exception.getMessage()));
        return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(response));
    }
}
