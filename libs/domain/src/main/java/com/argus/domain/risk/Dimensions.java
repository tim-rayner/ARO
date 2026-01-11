package com.argus.domain.risk;

import lombok.Getter;

public class Dimensions {

    @Getter
    private double cyber;

    @Getter
    private double geopolitical;

    @Getter
    private double economic;

    @Getter
    private double infrastructure;

    @Getter
    private double social;

    public void setCyber(double cyber) {
        this.cyber = clamp(cyber);
    }

    public void setGeopolitical(double geopolitical) {
        this.geopolitical = clamp(geopolitical);
    }

    public void setEconomic(double economic) {
        this.economic = clamp(economic);
    }

    public void setInfrastructure(double infrastructure) {
        this.infrastructure = clamp(infrastructure);
    }

    public void setSocial(double social) {
        this.social = clamp(social);
    }

    private static double clamp(double value) {
        return Math.max(0, Math.min(1, value));
    }
}
