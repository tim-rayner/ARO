package com.argus.domain.deed;

import java.util.Objects;

/**
 * Source-qualified identifier for a Deed.
 *
 * Format: <source>:<source-specific-id>
 * Example: gdelt:20260105-123456
 */
public record DeedId(String source, String externalId) {

    public DeedId {
        Objects.requireNonNull(source, "source must not be null");
        Objects.requireNonNull(externalId, "externalId must not be null");
    }

    public static DeedId of(String source, String externalId) {
        Objects.requireNonNull(source, "source must not be null");
        Objects.requireNonNull(externalId, "externalId must not be null");

        return new DeedId(
                source.toLowerCase(),
                externalId
        );
    }

    public static DeedId parse(String raw) {
        Objects.requireNonNull(raw, "raw id must not be null");

        String[] parts = raw.split(":", 2);
        if (parts.length != 2) {
            throw new IllegalArgumentException(
                    "Invalid DeedId format, expected <source>:<id>"
            );
        }

        return of(parts[0], parts[1]);
    }

    @Override
    public String toString() {
        return source + ":" + externalId;
    }
}
