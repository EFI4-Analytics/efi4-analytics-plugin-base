package com.efigence.mercury.model.segment;

import com.efigence.mercury.model.report.entity.Scope;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Filter {
    USERS(Scope.USER),
    SESSIONS(Scope.SESSION);

    @Getter
    private final Scope scope;
}
