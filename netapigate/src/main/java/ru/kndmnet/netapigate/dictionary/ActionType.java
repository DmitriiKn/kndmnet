package ru.kndmnet.netapigate.dictionary;

public enum ActionType {
    REGISTER(0, ServiceType.REGISTRATION)
    ;

    final int id;
    final ServiceType type;

    ActionType(int id, ServiceType type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public ServiceType getType() {
        return type;
    }
}
