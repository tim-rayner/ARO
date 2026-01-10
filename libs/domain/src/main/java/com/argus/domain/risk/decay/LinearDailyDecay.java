package com.argus.domain.risk.decay;

import java.time.Duration;

public record LinearDailyDecay(double decayPerDay) implements DecayPolicy {

    @Override
    public double apply(int initialMagnitude, Duration age) {
        double days = age.toHours() / 24.0;
        return Math.max(0, initialMagnitude - (decayPerDay * days));
    }
}
