package com.argus.domain.risk;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.argus.domain.actor.ActorId;
import com.argus.domain.deed.DeedId;
import com.argus.domain.deed.DeedType;

public record RiskDelta(
    ActorId actorId,
    SnapshotRef fromSnapshot,
    SnapshotRef toSnapshot,
    BigDecimal overallDelta,
    Map<RiskDimension, BigDecimal> dimensionDeltas,
    List<ContributingDeed> topContributingDeeds,
    String explanationSummary
) {
  public RiskDelta {
    Objects.requireNonNull(actorId, "entityId");
    Objects.requireNonNull(fromSnapshot, "fromSnapshot");
    Objects.requireNonNull(toSnapshot, "toSnapshot");
    Objects.requireNonNull(overallDelta, "overallDelta");
    Objects.requireNonNull(dimensionDeltas, "dimensionDeltas");
    Objects.requireNonNull(topContributingDeeds, "topContributingDeeds");

    // Optional but good: ensure time direction makes sense
    if (!toSnapshot.at().isAfter(fromSnapshot.at())) {
      throw new IllegalArgumentException("toSnapshot must be after fromSnapshot");
    }

    // Optional but good: defensive immutability (if you care)
    dimensionDeltas = Map.copyOf(dimensionDeltas);
    topContributingDeeds = List.copyOf(topContributingDeeds);
  }

  public record SnapshotRef(Instant at) {
    public SnapshotRef {
      Objects.requireNonNull(at, "at");
    }
  }

  public record ContributingDeed(
      DeedId deedId,
      DeedType category,
      BigDecimal impactScore
  ) {
    public ContributingDeed {
      Objects.requireNonNull(deedId, "deedId");
      Objects.requireNonNull(category, "category");
      Objects.requireNonNull(impactScore, "impactScore");
    }
  }
}