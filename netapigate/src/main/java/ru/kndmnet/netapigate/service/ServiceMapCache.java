package ru.kndmnet.netapigate.service;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import ru.kndmnet.netapigate.dictionary.ActionType;
import ru.kndmnet.netapigate.dictionary.ServiceType;

import java.util.HashMap;
import java.util.Map;

@Component
public class ServiceMapCache {

    private Map<ServiceType, Map<ActionType, String>> serviceActionMap = new HashMap<>();

    @PostConstruct
    private void init(){
        Map<ActionType, String> registrationActions = getActionTypeStringMap();
        serviceActionMap.put(ServiceType.REGISTRATION, registrationActions);
    }

    public String getUrlByAction(ActionType action){
        return serviceActionMap.get(action.getType()).get(action);
    }

    private Map<ActionType, String> getActionTypeStringMap() {
        Map<ActionType, String> registrationActions = new HashMap<>();
        registrationActions.put(ActionType.REGISTER, "http://usersrv/api/v1/user/registration");
        return registrationActions;
    }


}
