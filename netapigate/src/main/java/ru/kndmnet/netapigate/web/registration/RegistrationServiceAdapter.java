package ru.kndmnet.netapigate.web.registration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ru.kndmnet.netapigate.dictionary.ActionType;
import ru.kndmnet.netapigate.dto.registration.RegRequestDto;
import ru.kndmnet.netapigate.dto.registration.RegResponseDto;
import ru.kndmnet.netapigate.exception.ApiError;
import ru.kndmnet.netapigate.service.ServiceMapCache;
import ru.kndmnet.netapigate.task.InnerApiCallTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import static java.lang.Thread.sleep;

@Component
public class RegistrationServiceAdapter {
    private final RestTemplate restTemplate;
    private final ServiceMapCache serviceMapCache;
    private final ExecutorService executorService;

    public RegistrationServiceAdapter(RestTemplate restTemplate, ServiceMapCache serviceMapCache, ExecutorService executorService) {
        this.restTemplate = restTemplate;
        this.serviceMapCache = serviceMapCache;
        this.executorService = executorService;
    }

    public RegResponseDto callRegistrationService(Mono<RegRequestDto> requestDto) throws Exception {
            return executorService.submit(new Task(requestDto)).get();
    }

    private class Task extends InnerApiCallTask<RegRequestDto, RegResponseDto> {

        public Task(Mono<RegRequestDto> requestDto) {
            super(requestDto);
        }

        @Override
        public RegResponseDto getResponseDto(RegRequestDto dto) {
            try {
                return restTemplate.postForObject(serviceMapCache.getUrlByAction(ActionType.REGISTER),
                        dto, RegResponseDto.class);
            } catch (Exception exception) {
                var response = new RegResponseDto();
                response.setError(new ApiError(exception.getMessage()));
                return response;
            }
        }
    }
}
