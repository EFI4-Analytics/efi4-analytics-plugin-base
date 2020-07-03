package com.efigence.mercury.model.segment;

import java.util.List;
import java.util.UUID;

public interface SegmentRepository {
    List<Segment> findAll(UUID watUserId);
    Segment findById(String segmentId);
}
