package com.efigence.mercury.delivery.segment;

import com.efigence.mercury.model.segment.ComponentScope;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Value;

@ApiModel
@Builder
@Value
public class SegmentConditionDTO {

    @ApiModelProperty(example = "AND")
    String groupOperator;
    @ApiModelProperty(example = "metric.sessions")
    String componentConceptName;
    @ApiModelProperty(example = "PER_SESSION")
    ComponentScope componentScope;
    @ApiModelProperty(example = "operator.greaterThan")
    String operatorConceptName;
    @ApiModelProperty(example = "1")
    String parameter;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public SegmentConditionDTO(
            @JsonProperty("groupOperator") String groupOperator,
            @JsonProperty("componentConceptName") String componentConceptName,
            @JsonProperty("componentScope") ComponentScope componentScope,
            @JsonProperty("operatorConceptName") String operatorConceptName,
            @JsonProperty("parameter") String parameter) {
        this.groupOperator = groupOperator;
        this.componentConceptName = componentConceptName;
        this.componentScope = componentScope;
        this.operatorConceptName = operatorConceptName;
        this.parameter = parameter;
    }
}
