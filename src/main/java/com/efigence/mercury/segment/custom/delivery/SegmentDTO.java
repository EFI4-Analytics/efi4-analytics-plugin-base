package com.efigence.mercury.segment.custom.delivery;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.util.List;

@ApiModel
@Builder
@Value
public class SegmentDTO {
    String segmentId;
    String name;
    @Getter(AccessLevel.NONE) boolean isPublic;
    boolean isSystem;
    List<SegmentGroupDTO> groups;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SegmentDTO(
            @JsonProperty("segmentId") String segmentId,
            @JsonProperty("name") String name,
            @JsonProperty("isPublic") boolean isPublic,
            @JsonProperty("isSystem") boolean isSystem,
            @JsonProperty("groups") List<SegmentGroupDTO> groups) {
        this.segmentId = segmentId;
        this.name = name;
        this.isPublic = isPublic;
        this.isSystem = isSystem;
        this.groups = groups;
    }

    public boolean getIsPublic() {
        return isPublic;
    }
}
