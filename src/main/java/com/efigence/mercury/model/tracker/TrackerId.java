package com.efigence.mercury.model.tracker;

import com.google.common.base.Joiner;

import java.util.Objects;
import java.util.Random;
import java.util.UUID;

import static java.lang.String.format;

public class TrackerId {

    // TODO: fix validation pattern
    private static final String VALIDATION_PATTERN = "[a-zA-Z0-9-]{1,32}";
    private final String tracker;

    private TrackerId(String tracker) {
        validateTrackerId(tracker);
        this.tracker = tracker;
    }

    public static TrackerId generateNewTrackerId(UUID watUserId) {
        String tracker = Joiner.on("-")
                .join("EF", userPart(watUserId), randomPart());
        return new TrackerId(tracker);
    }

    public static TrackerId of(String trackerId) {
        return new TrackerId(trackerId);
    }

    private static int randomPart() {
        return new Random().nextInt(1000);
    }

    private static int userPart(UUID watUserId) {
        int base = (int) (watUserId.getLeastSignificantBits() % 100000000);
        return Math.abs(base);
    }

    private void validateTrackerId(String tracker) {
        if (!tracker.matches(VALIDATION_PATTERN)) {
            throw new IllegalArgumentException(format("Invalid trackerId: %s", tracker));
        }
    }

    public String getTracker() {
        return tracker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TrackerId)) return false;
        TrackerId trackerId = (TrackerId) o;
        return Objects.equals(tracker, trackerId.tracker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tracker);
    }

    @Override
    public String toString() {
        return tracker;
    }
}
