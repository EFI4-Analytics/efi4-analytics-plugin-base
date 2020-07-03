package com.efigence.mercury.usecase.logic.segment;

import com.efigence.mercury.model.report.entity.Period;
import com.efigence.mercury.model.segment.Segment;
import com.efigence.mercury.model.segment.SegmentStats;
import com.efigence.mercury.model.tracker.TrackerId;

import java.util.concurrent.CompletableFuture;

public interface SegmentStatsRepository {

    CompletableFuture<SegmentStats> getSegmentStats(Segment segment, Period period, TrackerId trackerId);
}
