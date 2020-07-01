package com.efigence.mercury.model.report.entity;

import static java.lang.String.format;

public enum Group implements Descriptable {
    USER("user"),
    SESSION("session"),
    TRAFFIC_SOURCES("trafficSources"),
    GOAL_CONVERSIONS("goalConversions"),
    PLATFORM_OR_DEVICE("platformOrDevice"),
    GEO_NETWORK("geoNetwork"),
    SYSTEM("system"),
    PAGE_TRACKING("pageTracking"),
    INTERNAL_SEARCH("internalSearch"),
    EVENT_TRACKING("eventTracking"),
    DATE_TIME("dateTime"),
    CHANNEL_GROUPING("channelGrouping"),
    LIFE_TIME_VALUE("lifeTimeValue");

    private static final String CONCEPT_NAME_PREFIX = "group.";
    private final String name;

    Group(String name) {
        this.name = name;
    }

    @Override
    public String getConceptName() {
        return CONCEPT_NAME_PREFIX + name;
    }

    @Override
    public String getConceptDescription() {
        return getConceptName() + DESCRIPTION_SUFFIX;
    }

    public static Group getByConceptName(String conceptName) {
        for (Group group : values()) {
            if (group.getConceptName().equalsIgnoreCase(conceptName)) {
                return group;
            }
        }
        throw new IllegalArgumentException(format("Group with concept name %s does not exist", conceptName));
    }
}
