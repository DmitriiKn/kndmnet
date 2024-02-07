package ru.kndmnet.netapigate.web.registration;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import ru.kndmnet.netapigate.dictionary.ActionType;
import ru.kndmnet.netapigate.dto.registration.RegRequestDto;
import ru.kndmnet.netapigate.dto.registration.RegResponseDto;
import ru.kndmnet.netapigate.service.ServiceMapCache;

@Component
public class RegistrationServiceAdapter {
    private final RestTemplate restTemplate;
    private final ServiceMapCache serviceMapCache;

    public RegistrationServiceAdapter(RestTemplate restTemplate, ServiceMapCache serviceMapCache) {
        this.restTemplate = restTemplate;
        this.serviceMapCache = serviceMapCache;
    }

    public RegResponseDto callRegistrationService(RegRequestDto requestDto){
        return restTemplate.postForObject(serviceMapCache.getUrlByAction(ActionType.REGISTER),
                requestDto, RegResponseDto.class);
    }
}
