package com.efigence.mercury.model.security;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

import java.util.List;
import java.util.UUID;

public class WatUser {

    private final UUID id;
    private final String name;
    private final List<String> roles;

    public WatUser(UUID id, String name, List<String> roles) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(name), "Name can't be empty");
        this.id = Preconditions.checkNotNull(id);
        this.roles = Preconditions.checkNotNull(roles);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getRoles() {
        return roles;
    }
}
