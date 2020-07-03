package com.efigence.mercury.model.common;

public interface EntityMapper {

    <T> T map(Object source, Class<T> destinationClass);

}
