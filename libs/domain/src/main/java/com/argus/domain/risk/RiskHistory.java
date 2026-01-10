package com.argus.domain.risk;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.argus.domain.actor.ActorId;

public record RiskHistory(
    ActorId actorId,
    Interval interval,
    Instant from,
    Instant to,
    List<Point> points
) {
  public RiskHistory {
    Objects.requireNonNull(actorId, "entityId");
    Objects.requireNonNull(interval, "interval");
    Objects.requireNonNull(from, "from");
    Objects.requireNonNull(to, "to");
    Objects.requireNonNull(points, "points");

    if (!to.isAfter(from)) {
      throw new IllegalArgumentException("'to' must be after 'from'");
    }

    // Ensure immutability of the list returned from this record
    points = List.copyOf(points);

    // Optional sanity checks (kept lightweight for performance)
    for (Point p : points) {
      if (p.time().isBefore(from) || p.time().isAfter(to)) {
        throw new IllegalArgumentException("Point time out of range: " + p.time());
      }
    }
  }

  /** Stronger than a raw string like "1h" but still UI-friendly. */
  public record Interval(Duration duration, String label) {
    public Interval {
      Objects.requireNonNull(duration, "duration");
      Objects.requireNonNull(label, "label");
      if (duration.isZero() || duration.isNegative()) {
        throw new IllegalArgumentException("interval duration must be positive");
      }
    }

    public static Interval ofHours(int hours) {
      if (hours <= 0) throw new IllegalArgumentException("hours must be > 0");
      return new Interval(Duration.ofHours(hours), hours + "h");
    }

    public static Interval ofMinutes(int minutes) {
      if (minutes <= 0) throw new IllegalArgumentException("minutes must be > 0");
      return new Interval(Duration.ofMinutes(minutes), minutes + "m");
    }

    public static Interval ofDays(int days) {
      if (days <= 0) throw new IllegalArgumentException("days must be > 0");
      return new Interval(Duration.ofDays(days), days + "d");
    }
  }

  public record Point(
      Instant time,
      BigDecimal overallScore
      // optional later: Map<RiskDimension, BigDecimal> dimensionScores
  ) {
    public Point {
      Objects.requireNonNull(time, "time");
      Objects.requireNonNull(overallScore, "overallScore");

      // Optional guardrails (depends on your scoring bounds)
      if (overallScore.compareTo(BigDecimal.ZERO) < 0 || overallScore.compareTo(BigDecimal.ONE) > 0) {
        throw new IllegalArgumentException("overallScore must be within [0, 1]");
      }
    }
  }
}