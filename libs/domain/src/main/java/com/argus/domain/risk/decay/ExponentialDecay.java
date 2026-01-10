package com.argus.domain.risk.decay;

import java.time.Duration;

public record ExponentialDecay(double halfLifeDays) implements DecayPolicy {

    @Override
    public double apply(int initialMagnitude, Duration age) {
        double days = age.toHours() / 24.0;
        return initialMagnitude * Math.pow(0.5, days / halfLifeDays);
    }
}
