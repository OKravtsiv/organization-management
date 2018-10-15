package com.softserveinc.testapi.domain.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserRights {
    COMMON((GrantedAuthority) () -> "COMMON"),
    MANAGER((GrantedAuthority) () -> "MANAGER"),
    ADMIN((GrantedAuthority) () -> "ADMIN");

    private GrantedAuthority authority;

    UserRights(GrantedAuthority authority) {
        this.authority = authority;
    }

    public GrantedAuthority getAuthority() {
        return authority;
    }
}
