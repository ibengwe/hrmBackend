package abe.version3.hrmv3.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Permission {

    ADMIN_READ("Admin :read"),

    ADMIN_UPDATE("Admin :update"),
    ADMIN_CREATE("Admin :create"),
    ADMIN_DELETE("Admin :delete"),

    OCS_READ("Ocs :read"),

    OCS_UPDATE("Ocs :update"),
    OCS_CREATE("Ocs :create"),
    OCS_DELETE("Ocs :delete"),


    USER_READ("User:read"),
    USER_UPDATE("User:read"),
    USER_DELETE("User:delete"),
    USER_CREATE("User:create")


    ;
    @Getter
    private final String permission;
}

