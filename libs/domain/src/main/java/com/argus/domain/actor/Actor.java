package com.argus.domain.actor;

import com.argus.domain.type.Type;

public record Actor(
        String entityId,
        Type type,
        String isoCode,
        String region,
        String name
) {}
