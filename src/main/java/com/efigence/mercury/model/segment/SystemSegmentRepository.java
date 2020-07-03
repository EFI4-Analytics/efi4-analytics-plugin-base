package com.efigence.mercury.model.segment;

import java.util.List;

public interface SystemSegmentRepository {
    List<Segment> findAll();

    Segment findById(String segmentId);
}
