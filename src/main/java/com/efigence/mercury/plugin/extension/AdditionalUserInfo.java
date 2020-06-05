package com.efigence.mercury.plugin.extension;


import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface AdditionalUserInfo {
    Map<String, Optional<String>> getAdditionalInfo(String trackerId, List<String> userIdList);
}
