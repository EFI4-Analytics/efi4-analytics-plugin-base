package com.efigence.mercury.model.segment;

import com.efigence.mercury.model.report.entity.Scope;
import lombok.Getter;

public enum ComponentScope {
    PER_USER(Scope.USER),
    PER_SESSION(Scope.SESSION),
    PER_HIT(Scope.HIT);

    @Getter
    private final Scope scope;

    ComponentScope(Scope scope) {
        this.scope = scope;
    }

    public static ComponentScope with(Scope scope) {
        for (ComponentScope cs : values()) {
            if (cs.scope == scope) {
                return cs;
            }
        }
        throw new IllegalArgumentException("No ComponentScope exists with Scope" + scope);
    }
}
