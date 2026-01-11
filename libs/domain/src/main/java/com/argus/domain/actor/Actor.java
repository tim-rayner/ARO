package com.argus.domain.actor;

import com.argus.domain.type.Type;

public record Actor(
        ActorId actorId,
        Type type,
        String isoCode,
        String region,
        String name
) {}
