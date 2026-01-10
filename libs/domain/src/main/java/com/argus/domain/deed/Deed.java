package com.argus.domain.deed;

import java.time.Instant;
import java.util.List;
import java.util.Objects;

import com.argus.domain.actor.Actor;

public record Deed(
        DeedId deedId,
        Instant observedAt,
        List<Actor> actors,
        DeedType deedType,
        double severity,
        String headline,
        double confidence,
        SourceRef sourceRef
) {
    public Deed {
        Objects.requireNonNull(deedId, "deedId must not be null");
        actors = actors == null ? List.of() : List.copyOf(actors);
    }
}
