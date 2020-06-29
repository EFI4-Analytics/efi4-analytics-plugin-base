package com.efigence.mercury.model.tracker;

import java.util.UUID;

public interface TrackerProvider {

    TrackerId get(UUID watUserId, String trackerIdStr);

    void checkUserIsAllowedForTracker(UUID watUserId, TrackerId trackerId);
}
