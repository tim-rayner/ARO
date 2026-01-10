package com.argus.domain.risk;

import java.time.Duration;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

import com.argus.domain.risk.decay.DecayPolicy;

/**
 * Impact represents the quantified effect a Deed has on an Entity
 * within a specific risk dimension.
 *
 * Impacts are immutable, bounded, and decay over time.
 */
public record Impact(UUID deedId, RiskDimension dimension, int magnitude, Instant occurredAt) {

    private static final int MIN_MAGNITUDE = 0;
    private static final int MAX_MAGNITUDE = 100;

    public Impact {
        Objects.requireNonNull(deedId, "deedId must not be null");
        Objects.requireNonNull(dimension, "dimension must not be null");
        Objects.requireNonNull(occurredAt, "occurredAt must not be null");

        if (magnitude < MIN_MAGNITUDE || magnitude > MAX_MAGNITUDE) {
            throw new IllegalArgumentException(
                    "Impact magnitude must be between " + MIN_MAGNITUDE + " and " + MAX_MAGNITUDE
            );
        }
    }

    /**
     * Returns the decayed magnitude at a given point in time.
     *
     * This does NOT mutate the Impact.
     */
    public int decayedValueAt(Instant evaluationTime, DecayPolicy decayPolicy) {
        Duration age = Duration.between(occurredAt, evaluationTime);
        double decayed = decayPolicy.apply(magnitude, age);
        return clamp((int) Math.round(decayed));
    }

    private int clamp(int value) {
        return Math.max(MIN_MAGNITUDE, Math.min(MAX_MAGNITUDE, value));
    }
}
