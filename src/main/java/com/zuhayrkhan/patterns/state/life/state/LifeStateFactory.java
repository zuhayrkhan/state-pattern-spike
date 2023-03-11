package com.zuhayrkhan.patterns.state.life.state;

import com.zuhayrkhan.patterns.state.life.service.LifeStateReporter;

public class LifeStateFactory {

    private final LifeStateReporter lifeStateReporter;

    public LifeStateFactory(LifeStateReporter lifeStateReporter) {
        this.lifeStateReporter = lifeStateReporter;
    }

    LifeState createLifeState(LifeState.State state) {
        return switch (state) {
            case ASLEEP -> new Asleep(lifeStateReporter);
            case AWAKE -> new Awake(lifeStateReporter);
            case HUNGRY -> new Hungry(lifeStateReporter);
            case TIRED -> new Tired(lifeStateReporter);
        };
    }

    Asleep createAsleep() {
        return new Asleep(lifeStateReporter);
    }

    Awake createAwake() {
        return new Awake(lifeStateReporter);
    }

    Hungry createHungry() {
        return new Hungry(lifeStateReporter);
    }

    Tired createTired() {
        return new Tired(lifeStateReporter);
    }

}
