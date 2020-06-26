package com.efigence.mercury.usecase.contract.common;

import com.efigence.cleanarchitecture.usecase.Response;

import java.util.List;

public interface ValidationResponse<S> extends Response {
    void onSuccess(S successObject);
    void onError(List<Error> errors);
}
