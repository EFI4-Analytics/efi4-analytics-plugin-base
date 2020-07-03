package com.efigence.mercury.usecase.contract.common;

import java.util.List;
import java.util.stream.Stream;

import static java.util.Arrays.asList;

public interface Validator<T, C> {

    void validate(T target, ValidationResult<C> errors, Class... hints);

    default boolean checkHints(Class[] passedHints, Class... hintsToCheck) {
        List<Class> passedHintsList = asList(passedHints);
        List<Class> hintsToCheckList = asList(hintsToCheck);

        boolean hintsAreValid = Stream.concat(passedHintsList.stream(), hintsToCheckList.stream())
                .allMatch(hint -> asList(hint.getInterfaces()).contains(ValidationHint.class));
        if (hintsAreValid) {
            return passedHintsList.containsAll(hintsToCheckList);
        }
        throw new IllegalArgumentException();
    }

    default String arrayIndex(int index) {
        return "[" + index + "]";
    }

    interface ValidationHint { }
}
