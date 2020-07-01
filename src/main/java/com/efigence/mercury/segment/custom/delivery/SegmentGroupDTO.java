package com.efigence.mercury.segment.custom.delivery;

import com.efigence.mercury.delivery.segment.SegmentConditionDTO;
import com.efigence.mercury.model.segment.Filter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@ApiModel
@Builder
@Value
public class SegmentGroupDTO {
    String name;
    boolean include;
    Filter filter;
    List<SegmentConditionDTO> conditions;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SegmentGroupDTO(
            @JsonProperty("name") String name,
            @JsonProperty("include") boolean include,
            @JsonProperty("filter") Filter filter,
            @JsonProperty("conditions") List<SegmentConditionDTO> conditions) {
        this.name = name;
        this.include = include;
        this.filter = filter;
        this.conditions = conditions;
    }
}
