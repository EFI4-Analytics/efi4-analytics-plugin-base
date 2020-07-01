package com.efigence.mercury.model.segment;

import com.efigence.mercury.model.report.entity.Component;
import com.efigence.mercury.model.report.entity.Scope;

public interface AllowedInSegment extends Component {
    String getSegmentExpression(Scope scope);
}
