package com.efigence.mercury.model.segment;

import com.google.common.collect.Iterables;

import java.util.List;

public interface Segment {

    String getSegmentId();
    String getName();
    boolean isPublic();
    boolean isSystem();
    List<SegmentGroup> getGroups();

    default boolean isEmpty() {
        return Iterables.isEmpty(getGroups());
    }
}
