package com.argus.domain.risk.decay;

import java.time.Duration;

public interface DecayPolicy {

    /**
     * Calculates the decayed impact magnitude.
     *
     * @param initialMagnitude original impact strength (int)
     * @param age time elapsed since occurrence (Duration)
     * @return decayed magnitude (not yet bounded)
     */
    double apply(int initialMagnitude, Duration age);
}
