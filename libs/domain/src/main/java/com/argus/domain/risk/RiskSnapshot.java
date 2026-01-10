package com.argus.domain.risk;

import java.util.Date;

import com.argus.domain.actor.ActorId;
import com.argus.domain.application.Application;

import lombok.Getter;
import lombok.Setter;

public class RiskSnapshot {

    @Getter @Setter
    private ActorId actorId;

    @Getter @Setter
    private Date snapshotTime;

    @Getter @Setter
    private double overallScore;

    @Getter @Setter
    private Dimensions dimensions;

    @Getter @Setter
    private double confidence;

    @Getter @Setter
    private Application lastUpdatedFrom;

}
