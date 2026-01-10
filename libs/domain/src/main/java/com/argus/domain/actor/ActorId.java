package com.argus.domain.actor;

import java.util.Objects;

/**
 * Source-qualified identifier for an Actor.
 *
 * Format: <actor-type>:<external-id>
 *
 * Examples:
 *  - country:GB
 *  - org:NATIONAL_GRID
 */
public record ActorId(String type, String externalId) {

    public ActorId {
        Objects.requireNonNull(type, "type must not be null");
        Objects.requireNonNull(externalId, "externalId must not be null");
    }

    public static ActorId of(String type, String externalId) {
        Objects.requireNonNull(type, "type must not be null");
        Objects.requireNonNull(externalId, "externalId must not be null");

        return new ActorId(
                type.toLowerCase(),
                externalId
        );
    }

    public static ActorId parse(String raw) {
        Objects.requireNonNull(raw, "raw actor id must not be null");

        String[] parts = raw.split(":", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid ActorId format, expected <type>:<id>"
            );
        }

        return of(parts[0], parts[1]);
    }

    @Override
    public String toString() {
        return type + ":" + externalId;
    }
}