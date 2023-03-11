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

        switch (label) {
            case ASLEEP:
                return new Asleep(lifeStateReporter);
            case AWAKE:
                return new Awake(lifeStateReporter);
            case HUNGRY:
                return new Hungry(lifeStateReporter);
            case TIRED:
                return new Tired(lifeStateReporter);
        }

        throw new IllegalArgumentException("Don't know how to create state for label:" + label);
    }

}
