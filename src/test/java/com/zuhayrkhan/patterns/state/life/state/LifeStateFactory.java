package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;
import com.zuhayrkhan.patterns.state.support.state.StateFactory;

public class LifeStateFactory implements StateFactory<LifeState> {

    private final LifeStateReporter lifeStateReporter;

    public LifeStateFactory(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    @Override
    public LifeState createState(Class<? extends LifeState> state) {

        if (state == Asleep.class) {
            return new Asleep(lifeStateReporter);
        }
        if (state == Awake.class) {
            return new Awake(lifeStateReporter);
        }
        if (state == Hungry.class) {
            return new Hungry(lifeStateReporter);
        }
        if (state == Tired.class) {
            return new Tired(lifeStateReporter);
        }

        throw new IllegalArgumentException("Don't know how to create state for state:" + state);
    }

}
