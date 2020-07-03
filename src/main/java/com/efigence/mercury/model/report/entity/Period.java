package com.efigence.mercury.model.report.entity;

import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static java.lang.String.format;

@Getter
@ToString(of = {"start", "end"})
public class Period {

    private final LocalDate start;
    private final LocalDate end;

    private Period(LocalDate start, LocalDate end) {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException(format("%s isn't before %s", start, end));
        }
        this.start = start;
        this.end = end;
    }

    public static Period between(LocalDate start, LocalDate end) {
        return new Period(start, end);
    }

    public LocalDateTime getStartTimestamp() {
        return start.atStartOfDay();
    }

    public LocalDateTime getEndTimestamp() {
        return end.plusDays(1).atStartOfDay();
    }

    public long getStartDay() {
        return start.toEpochDay();
    }

    public long getEndDay() {
        return end.toEpochDay();
    }
}
