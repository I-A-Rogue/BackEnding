package net.weg.wegproject.security.model;

import org.springframework.security.core.GrantedAuthority;

public enum Profile implements GrantedAuthority {

    ADMIN, CLIENT;

    @Override
    public String getAuthority() {
        return this.name();
    }

}
