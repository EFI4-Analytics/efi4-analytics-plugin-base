package com.efigence.mercury.model.segment;

import com.efigence.mercury.model.report.entity.Nameable;
import com.efigence.mercury.model.report.entity.ValueType;
import com.efigence.mercury.model.report.exception.NoOperatorException;
import com.google.common.collect.ImmutableSet;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.efigence.mercury.model.report.entity.ValueType.*;
import static java.lang.String.format;

public enum Operator implements Nameable {

    // Numeric operators
    EQUAL_TO("equalTo", "%s = %s::NUMERIC", getNumericTypes()),
    NOT_EQUAL_TO("notEqualTo", "%s != %s::NUMERIC", getNumericTypes()),
    GREATER_THAN("greaterThan", "%s > %s::NUMERIC", getNumericTypes()),
    LESS_THAN("lessThan", "%s < %s::NUMERIC", getNumericTypes()),
    GREATER_THAN_OR_EQUAL_TO("greaterThanOrEqualTo", "%s >= %s::NUMERIC", getNumericTypes()),
    LESS_THAN_OR_EQUAL_TO("lessThanOrEqualTo", "%s <= %s::NUMERIC", getNumericTypes()),

    // Text operators
    MATCHES("matches", "%s = %s", STRING),
    CONTAINS("contains", "%s LIKE '%%'||%s||'%%'", STRING),
    STARTS_WITH("startsWith", "%s LIKE %s||'%%'", STRING),
    ENDS_WITH("endsWith", "%s LIKE '%%'||%s'", STRING),
    REGEXP("regexp", "%s SIMILAR TO %s", STRING), // POSIX rexexp: '~'
    BELONGS_TO("belongsTo", "%s = ANY(string_to_array(%s, ','))", STRING),
    NOT_MATCHES("notMatches", "%s != %s", STRING),
    NOT_CONTAINS("notContains", "%s NOT LIKE '%%'||%s||'%%'", STRING),
    NOT_STARTS_WITH("notStartsWith", "%s NOT LIKE %s||'%%'", STRING),
    NOT_ENDS_WITH("notEndsWith", "%s NOT LIKE '%%'||%s'", STRING),
    NOT_REGEXP("notRegexp", "%s NOT SIMILAR TO %s", STRING),
    NOT_BELONGS_TO("notBelongsTo", "%s != ALL(string_to_array(%s, ','))", STRING),

    // Date operators
    BETWEEN("between", "%s::DATE BETWEEN SYMMETRIC (%2$s::JSON->>0)::DATE AND (%2$s::JSON->>1)::DATE", DATE),
    ON("on", "%s::DATE = %s::DATE", DATE),
    ON_BEFORE("onBefore", "%s::DATE <= %s::DATE", DATE),
    ON_AFTER("onAfter", "%s::DATE >= %s::DATE", DATE),

    //fixme its not binary operator but unary operator and ignores second parameter
    IS_NULL("isNull", "%s is null", STRING),
    IS_NOT_NULL("isNotNull", "%s is not null", STRING);

    private final String name;
    private final String condition;
    private final Set<ValueType> types;
    private static final String CONCEPT_NAME_PREFIX = "operator.";

    Operator(String name, String condition, ValueType... type) {
        this.name = name;
        this.condition = condition;
        this.types = ImmutableSet.copyOf(type);
    }

    Operator(String name, String condition, Collection<ValueType> types) {
        this.name = name;
        this.condition = condition;
        this.types = ImmutableSet.copyOf(types);
    }

    public static List<Operator> availableFor(ValueType type) {
        return Arrays.stream(values())
                .filter(operator -> operator.types.contains(type))
                .collect(Collectors.toList());
    }

    public String getResult(Object a, Object b) {
        return format(condition, a.toString(), b.toString());
    }

    public boolean supports(ValueType type) {
        return types.contains(type);
    }

    public static Operator getEnum(String conceptName) {
        return Arrays.stream(values())
                .filter(operator -> operator.getConceptName().equals(conceptName))
                .findFirst()
                .orElseThrow(() -> new NoOperatorException(conceptName));
    }

    @Override
    public String getConceptName() {
        return CONCEPT_NAME_PREFIX + name;
    }
}
