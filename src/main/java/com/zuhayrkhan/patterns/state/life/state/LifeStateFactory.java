package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;
import com.zuhayrkhan.patterns.state.support.state.StateFactory;

public class LifeStateFactory implements
        StateFactory<LifeState, LifeState.Label> {

    private final LifeStateReporter lifeStateReporter;

    public LifeStateFactory(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public LifeState createState(LifeState.Label label) {
        return switch (label) {
            case ASLEEP -> new Asleep(lifeStateReporter);
            case AWAKE -> new Awake(lifeStateReporter);
            case HUNGRY -> new Hungry(lifeStateReporter);
            case TIRED -> new Tired(lifeStateReporter);
        };
    }

}
